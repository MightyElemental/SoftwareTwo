import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {

  /** The name of the network */
  public String name;
  /** The users contained within the network keyed by their IDs */
  public Map<String, User> users;

  /**
   * Construct an instance of SocialNetwork
   * 
   * @param name the name of the network
   */
  public SocialNetwork(String name) {
    this(name, new HashMap<String, User>());
  }

  /**
   * Construct an instance of SocialNetwork
   * 
   * @param name the name of the network
   * @param users the users in the network
   */
  public SocialNetwork(String name, Map<String, User> users) {
    this.name = name;
    this.users = users;
  }

  /**
   * Construct a new user and add it to the network.
   * 
   * @param id the user ID
   * @param name the name of the user
   * @return The newly created user
   * @throws IllegalArgumentException If the user ID is already in the network
   */
  public User createUser(String id, String name) {
    if (users.containsKey(id)) { // If the user ID is already in the map, throw an exception
      throw new IllegalArgumentException("ID already exists in network");
    }
    User result = new User(id, name);
    users.put(id, result);
    return result;
  }

  /**
   * Returns a user from the network with a specific ID
   * 
   * @param id the user ID
   * @return The user with the specified ID
   * @throws IllegalArgumentException If the ID is not in the network
   */
  public User getUser(String id) {
    if (users.containsKey(id)) {
      return users.get(id);
    } else {
      throw new IllegalArgumentException("No user with this ID is in the network");
    }
  }

  /**
   * Add a relationship between two users
   * 
   * @param userOneId the first user ID
   * @param userTwoId the second user ID
   * @return {@code true} if connection was registered successfully, {@code false} otherwise
   * @throws IllegalArgumentException If one or both users do not exist in the network
   */
  public boolean addRelationship(String userOneId, String userTwoId) {
    User usrOne = getUser(userOneId);
    User usrTwo = getUser(userTwoId);
    // If either or both method calls return false, flag will be false.
    boolean flag = true;
    flag &= usrOne.addConnection(userTwoId);
    flag &= usrTwo.addConnection(userOneId);
    // return true if successfully added connection on both users
    return flag;
  }

  /**
   * Get the degree of closeness for a specified user
   * 
   * @param userId the user ID
   * @return The closeness of the user to the rest of the users in the network
   * @throws IllegalArgumentException If the user ID is not in the network
   */
  public double closeness(String userId) {
    if (!users.containsKey(userId)) {
      throw new IllegalArgumentException();
    }

    // calculate the distances to other users
    Map<String, Integer> distances = getConnectionDistances(userId);
    // sum all distances
    double totalDistance = distances.values().stream().mapToInt(Integer::intValue).sum();
    // C(x)
    return (users.size() - 1) / totalDistance;
  }

  /** Returns a map of users and their distances to the specified user */
  private Map<String, Integer> getConnectionDistances(String userId) {
    Map<String, Integer> distances = new HashMap<String, Integer>(users.size());
    // distance to self is zero
    distances.put(userId, 0);

    // using breadth first search to find distance to all other users

    LinkedList<String> todo = new LinkedList<String>();
    todo.add(userId);

    while (!todo.isEmpty()) {
      String currentId = todo.pop();

      Set<String> connections = getUser(currentId).getConnections();

      // depth is parent depth + 1
      int depth = distances.get(currentId) + 1;

      // for each connection, check if it has not already been added before adding it
      for (String c : connections) {
        if (!distances.containsKey(c)) {
          todo.push(c);
          distances.put(c, depth);
        }
      }
    }

    return distances;
  }

}
