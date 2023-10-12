
Tian Yu, 7219180

Description: 
This code simulates a car wash station with multithreading, where cars arrive, wait for available wash stations, and undergo the washing process. 

The Car class extends Thread and models car behavior. When a car arrives, it checks for available wash stations. If all stations are occupied, the car waits for up to 5 seconds. If it cannot find space within 5 seconds, the car leaves. When a car successfully enters a station, it undergoes the washing process and then leaves.

The CarWash class manages the car wash station. It maintains a queue of cars waiting for available stations and handles the washing process. If the queue is full, the car may wait for up to 5 seconds or leave if it exceeds the maximum wait time. The washCar method process the car wash for a fixed time and notifies waiting cars when a location becomes available.

In the Main class, a car wash station is created with a specified number of stations and station time. It then generates and starts threads for 10 cars, simulating their arrival and interaction with the car wash station.

Development environment:
java version "1.8.0_381"
Java(TM) SE Runtime Environment (build 1.8.0_381-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.381-b09, mixed mode)

Thank you Professor.