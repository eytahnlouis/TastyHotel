# Tasty Hotel
java project for college

1. Create a class named `Hotel` with the following attributes:
   - `name` (String): The name of the hotel.
   - `location` (String): The location of the hotel.
   - `rating` (double): The rating of the hotel (out of 5).
   - `pricePerNight` (double): The price per night for a room in the hotel.
   
2. Implement methods to:
   - Get and set the hotel's name.
   - Get and set the hotel's location.
   - Get and set the hotel's rating.
   - Get and set the hotel's price per night.
3. Create a class named `HotelManager` that manages a list of hotels. This class should have the following methods:
   - `addHotel(Hotel hotel)`: Adds a hotel to the list.
   - `removeHotel(String name)`: Removes a hotel from the list based on its name.
   - `getHotel(String name)`: Retrieves a hotel from the list based on its name.
   - `getAllHotels()`: Returns a list of all hotels.
4. Create a class named `Main` with a `main` method to demonstrate the functionality of the `Hotel` and `HotelManager` classes. In the `main` method, you can:
   - Create several `Hotel` objects with different attributes.
   - Add these hotels to the `HotelManager`.
   - Display the list of all hotels.
   - Retrieve and display a specific hotel by name.
     - Remove a hotel and display the updated list of hotels.
     - Modify a hotel's rating and display the updated list of hotels.