import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Simpletodolistt extends JFrame {

    DefaultListModel<String> database = new DefaultListModel<>();
    JList<String> todolist = new JList<>(database);
    JTextField inputfield = new JTextField();
    JButton addbutton = new JButton("Add");
    JButton deletebutton = new JButton("Delete");
    JButton markdonebutton = new JButton("Mark Done");

    File saveFile = new File("tasks.txt");

    public Simpletodolistt() {
        setTitle("📝 To-Do List Application");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 500));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputfield.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addbutton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addbutton.setBackground(new Color(0, 122, 255));
        addbutton.setForeground(Color.WHITE);
        topPanel.add(inputfield, BorderLayout.CENTER);
        topPanel.add(addbutton, BorderLayout.EAST);

        todolist.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        todolist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        todolist.setCellRenderer(new TaskRenderer());
        JScrollPane scrollPane = new JScrollPane(todolist);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        deletebutton.setBackground(new Color(255, 77, 77));
        deletebutton.setForeground(Color.WHITE);
        markdonebutton.setBackground(new Color(0, 200, 83));
        markdonebutton.setForeground(Color.WHITE);
        for (JButton b : new JButton[]{deletebutton, markdonebutton}) {
            b.setFont(new Font("Segoe UI", Font.BOLD, 13));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }
        bottomPanel.add(markdonebutton);
        bottomPanel.add(deletebutton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadTasks();

        addbutton.addActionListener(e -> addTask());
        inputfield.addActionListener(e -> addTask());
        deletebutton.addActionListener(e -> deleteTask());
        markdonebutton.addActionListener(e -> markTaskDone());

        todolist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = todolist.locationToIndex(e.getPoint());
                    if (index != -1) {
                        String current = database.get(index);
                        String updated = JOptionPane.showInputDialog("Edit Task:", current.replace("[DONE] ", ""));
                        if (updated != null && !updated.trim().isEmpty()) {
                            database.set(index, updated.trim());
                            saveTasks();
                        }
                    }
                }
            }
        });

        todolist.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) deleteTask();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveTasks();
            }
        });
    }

    private void addTask() {
        String task = inputfield.getText().trim();
        if (!task.isEmpty()) {
            database.addElement(task);
            inputfield.setText("");
            saveTasks();
        }
    }

    private void deleteTask() {
        int index = todolist.getSelectedIndex();
        if (index != -1) {
            database.remove(index);
            saveTasks();
        }
    }

    private void markTaskDone() {
        int index = todolist.getSelectedIndex();
        if (index != -1) {
            String task = database.get(index);
            if (!task.startsWith("[DONE]")) {
                database.set(index, "[DONE] " + task);
                saveTasks();
            }
        }
    }

    private void saveTasks() {
        try (PrintWriter out = new PrintWriter(new FileWriter(saveFile))) {
            for (int i = 0; i < database.size(); i++)
                out.println(database.get(i));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "⚠️ Failed to save tasks. Please check your file permissions or storage space.",
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void loadTasks() {
        if (saveFile.exists()) {
            try (Scanner in = new Scanner(saveFile)) {
                while (in.hasNextLine())
                    database.addElement(in.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String text = value.toString();
            if (text.startsWith("[DONE]")) {
                label.setForeground(Color.GRAY);
                label.setFont(label.getFont().deriveFont(Font.ITALIC));
            }
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Simpletodolistt().setVisible(true));
    }
}
