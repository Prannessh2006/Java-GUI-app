# 📝 Simple To-Do List Application

> A clean, minimal, and user-friendly desktop To-Do List application built with Java Swing

## 📖 Overview

This is a simple yet powerful desktop To-Do List application that helps you manage your daily tasks efficiently. Built using Java Swing, it provides an intuitive graphical user interface with essential task management features including adding, editing, marking as complete, and deleting tasks. All your tasks are automatically saved to a local file, ensuring your data persists between sessions.

## ✨ Features

### ➕ Add Tasks
- Enter a task in the input field
- Click the **Add** button or press **Enter** to add it to your list
- Tasks appear instantly in the list view

### ✏️ Edit Tasks
- **Double-click** on any task to edit its content
- Make your changes and they're saved immediately
- Perfect for updating task descriptions on the fly

### ✅ Mark Tasks As Done
- Select a task from the list
- Click the **Mark Done** button
- Completed tasks are displayed in *italic gray* text with a **[DONE]** tag
- Easily distinguish between pending and completed tasks

### 🗑️ Delete Tasks
- Select a task you want to remove
- Click the **Delete** button, or
- Simply press the **Delete** key on your keyboard
- Tasks are removed instantly from the list

### 💾 Auto-Saving
- All tasks are automatically saved to `tasks.txt`
- Tasks are restored automatically when you restart the app
- No need to manually save your work
- Your data is always safe

### 🎨 Modern User Interface
- **Clean Layout**: Minimalist design focused on productivity
- **Segoe UI Font**: Professional and easy-to-read typography
- **Colored Buttons**: 
  - 🟢 Green "Add" button for adding tasks
  - 🟡 Yellow "Mark Done" button for completing tasks
  - 🔴 Red "Delete" button for removing tasks
- **Custom Cell Renderer**: Completed tasks have distinct visual styling
- **Responsive Design**: Works smoothly on different screen sizes

## 🗂️ Project Structure

```
Simple-To-Do-Application/
│
├── .java                    # Main application source code
├── README.md                # Project documentation (this file)
└── tasks.txt                # Auto-generated file for storing tasks
```

### File Descriptions

- **`.java`**: Contains the main Java Swing application code with GUI components and task management logic
- **`tasks.txt`**: Automatically created text file that stores all your tasks persistently
- **`README.md`**: Complete project documentation with features and usage instructions

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Installation & Running

#### Option 1: Using Command Line

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Prannessh2006/Simple-to-do-application.git
   cd Simple-to-do-application
   ```

2. **Compile the Java file**:
   ```bash
   javac .java
   ```

3. **Run the application**:
   ```bash
   java ToDoListApp
   ```

#### Option 2: Using an IDE

1. Open your Java IDE
2. Import the project or open the `.java` file
3. Run the main class
4. The application window will appear

## 📱 Usage Guide

### Adding a New Task
1. Type your task in the input field at the top
2. Click the green **Add** button or press **Enter**
3. Your task appears in the list below

### Editing an Existing Task
1. **Double-click** the task you want to edit
2. The task text becomes editable
3. Make your changes and press **Enter** or click outside

### Marking a Task as Complete
1. Click on the task to select it
2. Click the yellow **Mark Done** button
3. The task changes to italic gray with a [DONE] tag

### Deleting a Task
1. Select the task you want to remove
2. Either:
   - Click the red **Delete** button, or
   - Press the **Delete** key on your keyboard
3. The task is removed from the list

### Task Persistence
- All tasks are automatically saved to `tasks.txt` in the same directory
- When you close and reopen the application, all your tasks are restored
- Both pending and completed tasks are preserved

## 🛠️ Technical Details

### Technologies Used
- **Language**: Java
- **GUI Framework**: Java Swing
- **File I/O**: Java BufferedReader/BufferedWriter for persistence
- **Data Structure**: DefaultListModel for managing task list

### Key Components
- **JFrame**: Main application window
- **JTextField**: Input field for new tasks
- **JList**: Displays all tasks
- **JButton**: Action buttons (Add, Mark Done, Delete)
- **DefaultListCellRenderer**: Custom renderer for styled task display

### Features Implementation
- **Task Storage Format**: Each task is stored as a line in `tasks.txt`
- **Done Tasks**: Prefixed with "[DONE] " in the file
- **Event Listeners**: ActionListeners and KeyListeners for user interactions
- **Error Handling**: Graceful handling of file I/O exceptions

## 📸 Screenshots

*Note: Add screenshots of your application here to showcase the UI*

## 🔮 Future Enhancements

Potential features for future versions:
- 🗓️ Due dates and reminders
- 🏷️ Task categories/tags
- ⭐ Priority levels (High, Medium, Low)
- 🔍 Search and filter functionality
- 📊 Task statistics and productivity metrics
- 🌙 Dark mode theme
- ☁️ Cloud sync capabilities
- 📤 Export tasks to different formats (PDF, CSV)

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
5. Push to the branch (`git push origin feature/AmazingFeature`)
6. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Prannessh2006**
- GitHub: [@Prannessh2006](https://github.com/Prannessh2006)

## 🙏 Acknowledgments

- Java Swing documentation and community
- All contributors and users of this application
- Open source community for inspiration

## 📞 Support

If you encounter any issues or have questions:
- Open an issue on GitHub
- Check existing issues for solutions
- Contribute to discussions

---

**Made with ❤️ using Java Swing**
