package view;

import controller.TaskManager;
import model.Status;
import model.Task;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

public class Frame extends JFrame implements ActionListener{
    private JFrame frame;
    private JPanel contentPanel;
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameTaskInput;
    private JTextArea descriptionTaskInput;
    private JXDatePicker dateStart;
    private JXDatePicker dateEnd;
    private JComboBox<Status> statusTask;
    private TaskManager taskManager;
    private JButton addButton;
    public Frame(TaskManager taskManager){
        this.taskManager = taskManager;

        frame = new JFrame();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Mes tâches");

        java.net.URL imgUrl = getClass().getResource("logo.png");
        ImageIcon icon = new ImageIcon(imgUrl);
        frame.setIconImage(icon.getImage());

        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(300,300));
        frame.add(contentPanel, BorderLayout.CENTER);

        JLabel nameTaskLabel = new JLabel("Nom de la tâche");
        contentPanel.add(nameTaskLabel);
        nameTaskInput = new JTextField(20);
        contentPanel.add(nameTaskInput);

        JLabel descriptionTaskLabel = new JLabel("Description");
        descriptionTaskLabel.setPreferredSize(new Dimension(80,20));
        contentPanel.add(descriptionTaskLabel);
        descriptionTaskInput = new JTextArea();
        descriptionTaskInput.setColumns(40);
        descriptionTaskInput.setRows(10);
        contentPanel.add(descriptionTaskInput);

        JLabel startDateLabel = new JLabel("Début de la tâche");
        contentPanel.add(startDateLabel);
        dateStart = new JXDatePicker();
        contentPanel.add(dateStart);

        JLabel endDateLabel = new JLabel("Fin de la tâche");
        contentPanel.add(endDateLabel);
        dateEnd = new JXDatePicker();
        contentPanel.add(dateEnd);

        Status[] status = {Status.TODO, Status.IN_PROGRESS, Status.DONE};
        statusTask = new JComboBox<>(status);
        contentPanel.add(statusTask);

        addButton = new JButton("Ajouter");
        addButton.addActionListener(this);
        contentPanel.add(addButton);

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(this);

        String[] columnNames = {"Nom de la tâche", "Description", "Date début", "Date fin", "Priorité", "Action"};
        Object[][] data = new Object[taskManager.getTasks().size()][6];
        int i = 0;
        for(Task task : taskManager.getTasks()) {
            data[i][0] = task.getNameTask();
            data[i][1] = task.getDescriptionTask();
            data[i][2] = task.getStartDateTask();
            data[i][3] = task.getEndDateTask();
            data[i][4] = task.getStatusTask();
            data[i][5] = deleteButton;
            i++;
        }
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        contentPanel.add(scrollPane);


        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String taskName = nameTaskInput.getText();
            String taskDescription = descriptionTaskInput.getText();
            LocalDate taskStartDate = dateStart.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate taskEndDate = dateEnd.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Status taskStatus = (Status) statusTask.getSelectedItem();

            taskManager.addTask(taskName, taskDescription, taskStartDate, taskEndDate, taskStatus);

            Object[] rowData = {taskName, taskDescription, taskStartDate, taskEndDate, taskStatus};
            model.addRow(rowData);
        }
    }
}

