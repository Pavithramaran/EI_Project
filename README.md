# Exercise 1
# Behavioural Design Pattern
## 1. Online Auction System – Observer Pattern

**Use Case:**

In an online auction, all bidders must be notified whenever the bid price changes. This application models that scenario using the Observer Pattern.

**Design Pattern:**

Subject: Auction class, which maintains the current bid price and notifies all bidders when updated.

Observers: Bidder classes that receive updates about price changes.

**Classes**

Auction: Maintains the list of bidders and the current bid price.

Bidder: Implements the observer interface to receive bid updates.

Observer: Generic observer interface.

AuctionSystemMain: Main entry point for running the auction simulation.

## 2. Logging Framework – Chain of Responsibility Pattern

**Use Case:**

A logging system where requests can be handled at multiple levels: console logs, file logs, and error logs in sequence.

**Design Pattern**

Each logger decides whether to handle a request or pass it to the next logger in the chain.

**Classes**

Logger: Abstract handler in the chain.

ConsoleLogger, FileLogger, ErrorLogger: Concrete handlers.

LoggerMain: Runs the framework and demonstrates chained logging.

# Structural Design Pattern
## 1. Media Player – Adapter Pattern

**Use Case:**

A base player supports only .mp3 files. Using an Adapter, the system can extend functionality to play .mp4 and .vlc files.

**Design Pattern:**

Adapter: MediaAdapter class adapts unsupported formats into supported ones.

Target: AudioPlayer class.

Adaptees: AdvancedMediaPlayer implementations like VlcPlayer and Mp4Player.

**Classes**

AudioPlayer: Default player.

MediaAdapter: Adapter to support additional formats.

AdvancedMediaPlayer: Interface for advanced formats.

VlcPlayer, Mp4Player: Concrete advanced players.

## 2. Coffee Shop – Decorator Pattern

**Use Case:**

A coffee shop where customers can add milk, sugar, or chocolate to a base coffee dynamically.

**Design Pattern:**

Component: Coffee interface.

Concrete Component: SimpleCoffee class.

Decorators: MilkDecorator, SugarDecorator, ChocolateDecorator.

**Classes:**

Coffee: Base interface.

SimpleCoffee: Default coffee.

MilkDecorator, SugarDecorator, ChocolateDecorator: Add-ons.

CoffeeShopMain: Demonstrates dynamic combinations.

# Creational Design Pattern
## 1. Notification System – Factory Method Pattern

**Use Case:**

A notification system where users can send Email, SMS, or Push notifications.

**Design Pattern:**

Factory class decides which notification type to create based on user choice.

**Classes:**

Notification: Abstract class.

EmailNotification, SMSNotification, PushNotification: Concrete notifications.

NotificationFactory: Factory class.

## 2.Meal Ordering System – Builder Pattern

**Use Case:**

A meal ordering system where customers can build customized meals by combining different items such as burgers, drinks, and desserts. The Builder Pattern allows step-by-step creation of meals with flexibility in adding or omitting components.

**Design Pattern:**

Builder Pattern is used to construct complex meal objects.

It separates the construction process from the representation, allowing the same process to create different meal types.

**Classes:**

Item: Interface representing a meal item (e.g., Burger, Drink).

Burger, Drink: Abstract classes implementing Item.

VegBurger, ChickenBurger: Concrete burger items.

Coke, Pepsi: Concrete drink items.

Meal: Represents a collection of items. Provides methods to add items, calculate cost, and display meal contents.

MealBuilder: Defines methods to build standard meals (Veg Meal, Non-Veg Meal).

MealOrderingSystemMain: Main class that lets users build and view meals.

# Exercise 2 
# Astronaut Daily Schedule Organizer

**Use Case Overview:**
  The Astronaut Daily Schedule Organizer is a console-based application designed to help astronauts plan and manage their daily activities efficiently. The system allows users to add, remove, and view tasks with details such as description, start time, end time, and priority level.

  The application ensures that tasks do not overlap, maintains tasks in chronological order, and provides flexibility for managing and reviewing the daily schedule. In addition to the core features, the system also supports optional functionalities such as editing tasks, marking tasks as completed, summarizing the daily schedule, and viewing tasks filtered by priority level.

**Functional Requirements:**

Add, remove, and view tasks (sorted by start time).

Validate overlapping tasks.

Error handling for invalid operations.

**Extra Features Added:**

Daily schedule summarizer.

View tasks by priority.

**Design Patterns Used:**

**Singleton Pattern:**

ScheduleManager ensures only one instance manages all tasks.

**Factory Pattern:**

TaskFactory creates task objects with given attributes.

**Observer Pattern:**

Alerts users if new tasks conflict with existing ones.

**Classes Overview:**

Task: Represents a daily task.

TaskFactory: Creates task objects.

ScheduleManager: Manages tasks (Singleton).

TaskObserver: Notifies about conflicts.

ScheduleAppMain: Entry point with user menu.

**Example Inputs & Outputs:**

Positive Cases:

Add Task → "Morning Exercise", "07:00-08:00", High → Task added successfully.

<img width="585" height="304" alt="Screenshot 2025-10-01 224202" src="https://github.com/user-attachments/assets/225866e8-532a-4602-8cb5-610a64967ac1" />

View Tasks → Lists tasks in chronological order.

<img width="394" height="237" alt="Screenshot 2025-10-01 224412" src="https://github.com/user-attachments/assets/c792c432-b5b7-4085-a897-a386301e317e" />

Remove Task → Delete existing task.

<img width="435" height="232" alt="Screenshot 2025-10-01 224516" src="https://github.com/user-attachments/assets/16c4ec11-bcc6-4c21-9965-a21b4eba6ae0" />

View Tasks by Priority → Filter by priority.

<img width="391" height="242" alt="Screenshot 2025-10-01 224650" src="https://github.com/user-attachments/assets/df9ac278-88f2-4276-a28b-44a6bdf610b7" />

Daily Summary → Overview of schedule.

<img width="563" height="177" alt="Screenshot 2025-10-01 224835" src="https://github.com/user-attachments/assets/4b0668e9-04e2-44a2-b329-f69215cce9cb" />

Negative Cases:

Add Task "Training Session", "09:30-10:30", High" → Error: Conflicts with "Team Meeting".

<img width="496" height="311" alt="Screenshot 2025-10-01 224933" src="https://github.com/user-attachments/assets/d6e583b6-404c-412c-a337-a22b9495b0e2" />

Remove "Non-existent Task" → Error: Task not found.

<img width="448" height="231" alt="Screenshot 2025-10-01 225010" src="https://github.com/user-attachments/assets/1f3b6b75-bd0c-4f58-bfc8-72b8b0912d81" />



**Contact Information:**

Email: pavithraaravimaran@gmail.com
