import java.util.ArrayList;
import java.util.List;

public class TrafficManagementSystem {

  // A list of roads in the network
  private List<Road> roads;

  // A list of intersections in the network
  private List<Intersection> intersections;

  // A list of vehicles currently on the roads
  private List<Vehicle> vehicles;

  public TrafficManagementSystem() {
    roads = new ArrayList<>();
    intersections = new ArrayList<>();
    vehicles = new ArrayList<>();
  }

  // Add a new road to the network
  public void addRoad(Road road) {
    roads.add(road);
  }

  // Add a new intersection to the network
  public void addIntersection(Intersection intersection) {
    intersections.add(intersection);
  }

  // Add a new vehicle to the network
  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  // Update the state of the traffic based on the rules of the simulation
  public void update() {
    // Update the position of each vehicle based on its current speed and direction
    for (Vehicle vehicle : vehicles) {
      vehicle.updatePosition();
    }

    // Update the traffic signals at each intersection based on the current traffic patterns
    for (Intersection intersection : intersections) {
      intersection.updateTrafficSignals();
    }
  }
}
