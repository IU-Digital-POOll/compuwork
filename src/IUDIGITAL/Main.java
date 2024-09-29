package IUDIGITAL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();
    private static List<ReporteDesempenio> reportes = new ArrayList<>();
    private static DefaultTableModel empleadosModel;
    private static DefaultTableModel departamentosModel;
    private static DefaultTableModel reportesModel;
    private static JTable empleadosTable;
    private static JTable departamentosTable;
    private static JTable reportesTable;
    private static LinkedTransferQueue<JScrollPane> frame;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Empleados y Departamentos");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JTabbedPane tabbedPane = new JTabbedPane();
        panel.add(tabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton createEmployeeButton = new JButton("Crear Empleado");
        buttonPanel.add(createEmployeeButton, gbc);
        createEmployeeButton.addActionListener(e -> createEmployee());

        gbc.gridy++;
        JButton updateEmployeeButton = new JButton("Actualizar Empleado");
        buttonPanel.add(updateEmployeeButton, gbc);
        updateEmployeeButton.addActionListener(e -> updateEmployee());

        gbc.gridy++;
        JButton deleteEmployeeButton = new JButton("Eliminar Empleado");
        buttonPanel.add(deleteEmployeeButton, gbc);
        deleteEmployeeButton.addActionListener(e -> deleteEmployee());

        gbc.gridy++;
        JButton createDepartamentButton = new JButton("Crear Departamento");
        buttonPanel.add(createDepartamentButton, gbc);
        createDepartamentButton.addActionListener(e -> createDepartament());

        gbc.gridy++;
        JButton updateDepartamentButton = new JButton("Actualizar Departamento");
        buttonPanel.add(updateDepartamentButton, gbc);
        updateDepartamentButton.addActionListener(e -> updateDepartament());

        gbc.gridy++;
        JButton deleteDepartamentButton = new JButton("Eliminar Departamento");
        buttonPanel.add(deleteDepartamentButton, gbc);
        deleteDepartamentButton.addActionListener(e -> deleteDepartament());

        gbc.gridy++;
        JButton assignDepartmentButton = new JButton("Asignar empleado a Departamento");
        buttonPanel.add(assignDepartmentButton, gbc);
        assignDepartmentButton.addActionListener(e -> assignDepartment());

        gbc.gridy++;
        JButton viewEmployeesButton = new JButton("Visualizar Empleados");
        buttonPanel.add(viewEmployeesButton, gbc);
        viewEmployeesButton.addActionListener(e -> viewEmployees());

        gbc.gridy++;
        JButton createReportButton = new JButton("Crear Reporte");
        buttonPanel.add(createReportButton, gbc);
        createReportButton.addActionListener(e -> createReport());

        gbc.gridy++;
        JButton viewReportsButton = new JButton("Visualizar Reportes");
        buttonPanel.add(viewReportsButton, gbc);
        viewReportsButton.addActionListener(e -> viewReports());

        panel.add(buttonPanel, BorderLayout.WEST);

        JPanel empleadosPanel = new JPanel(new BorderLayout());
        JPanel departamentosPanel = new JPanel(new BorderLayout());
        JPanel reportesPanel = new JPanel(new BorderLayout());

        tabbedPane.addTab("Empleados", empleadosPanel);
        tabbedPane.addTab("Departamentos", departamentosPanel);
        tabbedPane.addTab("Reportes", reportesPanel);

        empleadosModel = new DefaultTableModel(new String[]{"Identidad", "Nombre", "Apellido", "Tipo Empleado", "Teléfono", "Correo", "Dirección", "Fecha Contratación", "Cargo", "Salario"}, 0);
        empleadosTable = new JTable(empleadosModel);
        empleadosPanel.add(new JScrollPane(empleadosTable), BorderLayout.CENTER);

        departamentosModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Jefe", "Lista Empleados", "Descripción", "Gerente"}, 0);
        departamentosTable = new JTable(departamentosModel);
        departamentosPanel.add(new JScrollPane(departamentosTable), BorderLayout.CENTER);

        reportesModel = new DefaultTableModel(new String[]{"ID Reporte", "Empleados", "Fecha Reporte", "Puntaje Desempeño", "Comentario", "Departamento Reporte"}, 0);
        reportesTable = new JTable(reportesModel);
        reportesPanel.add(new JScrollPane(reportesTable), BorderLayout.CENTER);

        frame.setVisible(true);
    }
    //metodo crear empleados
    private static void createEmployee() {
        JTextField identidadField = new JTextField(5);
        JTextField nombreField = new JTextField(5);
        JTextField apellidoField = new JTextField(5);
        JTextField tipoEmpleadoField = new JTextField(5);
        JTextField telefonoField = new JTextField(5);
        JTextField correoField = new JTextField(5);
        JTextField direccionField = new JTextField(5);
        JTextField fechaContratacionField = new JTextField(5);
        JTextField cargoField = new JTextField(5);
        JTextField salarioField = new JTextField(5);

        JPanel myPanel = new JPanel(new GridLayout(0, 2));
        myPanel.add(new JLabel("Identidad:"));
        myPanel.add(identidadField);
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Apellido:"));
        myPanel.add(apellidoField);
        myPanel.add(new JLabel("Tipo Empleado:"));
        myPanel.add(tipoEmpleadoField);
        myPanel.add(new JLabel("Teléfono:"));
        myPanel.add(telefonoField);
        myPanel.add(new JLabel("Correo:"));
        myPanel.add(correoField);
        myPanel.add(new JLabel("Dirección:"));
        myPanel.add(direccionField);
        myPanel.add(new JLabel("Fecha Contratación:"));
        myPanel.add(fechaContratacionField);
        myPanel.add(new JLabel("Cargo:"));
        myPanel.add(cargoField);
        myPanel.add(new JLabel("Salario:"));
        myPanel.add(salarioField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Crear Empleado", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                long identidad = Long.parseLong(identidadField.getText());
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String tipoEmpleado = tipoEmpleadoField.getText();
                long telefono = Long.parseLong(telefonoField.getText());
                String correo = correoField.getText();
                String direccion = direccionField.getText();
                String fechaContratacion = fechaContratacionField.getText();
                String cargo = cargoField.getText();
                double salario = Double.parseDouble(salarioField.getText());

                Empleado empleado = new Empleado(identidad, nombre, apellido, tipoEmpleado, telefono, correo, direccion, fechaContratacion, cargo, salario);
                empleados.add(empleado);
                empleadosModel.addRow(new Object[]{identidad, nombre, apellido, tipoEmpleado, telefono, correo, direccion, fechaContratacion, cargo, salario});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Por favor, intente de nuevo.");
            }
        }
    }
    //metodo para actualizar empleados
    private static void updateEmployee() {
        int selectedRow = empleadosTable.getSelectedRow();
        if (selectedRow != -1) {
            JTextField identidadField = new JTextField(empleadosModel.getValueAt(selectedRow, 0).toString());
            JTextField nombreField = new JTextField(empleadosModel.getValueAt(selectedRow, 1).toString());
            JTextField apellidoField = new JTextField(empleadosModel.getValueAt(selectedRow, 2).toString());
            JTextField tipoEmpleadoField = new JTextField(empleadosModel.getValueAt(selectedRow, 3).toString());
            JTextField telefonoField = new JTextField(empleadosModel.getValueAt(selectedRow, 4).toString());
            JTextField correoField = new JTextField(empleadosModel.getValueAt(selectedRow, 5).toString());
            JTextField direccionField = new JTextField(empleadosModel.getValueAt(selectedRow, 6).toString());
            JTextField fechaContratacionField = new JTextField(empleadosModel.getValueAt(selectedRow, 7).toString());
            JTextField cargoField = new JTextField(empleadosModel.getValueAt(selectedRow, 8).toString());
            JTextField salarioField = new JTextField(empleadosModel.getValueAt(selectedRow, 9).toString());

            JPanel myPanel = new JPanel(new GridLayout(0, 2));
            myPanel.add(new JLabel("Identidad:"));
            myPanel.add(identidadField);
            myPanel.add(new JLabel("Nombre:"));
            myPanel.add(nombreField);
            myPanel.add(new JLabel("Apellido:"));
            myPanel.add(apellidoField);
            myPanel.add(new JLabel("Tipo Empleado:"));
            myPanel.add(tipoEmpleadoField);
            myPanel.add(new JLabel("Teléfono:"));
            myPanel.add(telefonoField);
            myPanel.add(new JLabel("Correo:"));
            myPanel.add(correoField);
            myPanel.add(new JLabel("Dirección:"));
            myPanel.add(direccionField);
            myPanel.add(new JLabel("Fecha Contratación:"));
            myPanel.add(fechaContratacionField);
            myPanel.add(new JLabel("Cargo:"));
            myPanel.add(cargoField);
            myPanel.add(new JLabel("Salario:"));
            myPanel.add(salarioField);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Actualizar Empleado", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String identidad = identidadField.getText();
                    String nombre = nombreField.getText();
                    String apellido = apellidoField.getText();
                    String tipoEmpleado = tipoEmpleadoField.getText();
                    String telefono = telefonoField.getText();
                    String correo = correoField.getText();
                    String direccion = direccionField.getText();
                    String fechaContratacion = fechaContratacionField.getText();
                    String cargo = cargoField.getText();
                    double salario = Double.parseDouble(salarioField.getText());

                    empleadosModel.setValueAt(identidad, selectedRow, 0);
                    empleadosModel.setValueAt(nombre, selectedRow, 1);
                    empleadosModel.setValueAt(apellido, selectedRow, 2);
                    empleadosModel.setValueAt(tipoEmpleado, selectedRow, 3);
                    empleadosModel.setValueAt(telefono, selectedRow, 4);
                    empleadosModel.setValueAt(correo, selectedRow, 5);
                    empleadosModel.setValueAt(direccion, selectedRow, 6);
                    empleadosModel.setValueAt(fechaContratacion, selectedRow, 7);
                    empleadosModel.setValueAt(cargo, selectedRow, 8);
                    empleadosModel.setValueAt(salario, selectedRow, 9);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Por favor, intente de nuevo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un empleado para actualizar.");
        }
    }
    //metodo para eliminar empleados
    private static void deleteEmployee() {
        int selectedRow = empleadosTable.getSelectedRow();
        if (selectedRow != -1) {
            empleadosModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un empleado para eliminar.");
        }
    }
    //metodo para asignar departamento
    private static void assignDepartment() {
        int selectedRow = empleadosTable.getSelectedRow();
        if (selectedRow != -1) {
            String empleado = empleadosModel.getValueAt(selectedRow, 1).toString();
            JTextField departamentoField = new JTextField(5);

            JPanel myPanel = new JPanel(new GridLayout(0, 2));
            myPanel.add(new JLabel("Departamento:"));
            myPanel.add(departamentoField);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Asignar Departamento a " + empleado, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String departamento = departamentoField.getText();
                empleadosModel.setValueAt(departamento, selectedRow, 3); // Assuming column 3 is for department
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un empleado para asignar un departamento.");
        }
    }
    // metodo para actualizar departamentos
    private static void updateDepartament() {
        int selectedRow = departamentosTable.getSelectedRow();
        if (selectedRow != -1) {
            JTextField idField = new JTextField(departamentosModel.getValueAt(selectedRow, 0).toString());
            JTextField nombreField = new JTextField(departamentosModel.getValueAt(selectedRow, 1).toString());
            JTextField jefeField = new JTextField(departamentosModel.getValueAt(selectedRow, 2).toString());
            JTextField listaEmpleadosField = new JTextField(departamentosModel.getValueAt(selectedRow, 3).toString());
            JTextField descripcionField = new JTextField(departamentosModel.getValueAt(selectedRow, 4).toString());
            JTextField gerenteField = new JTextField(departamentosModel.getValueAt(selectedRow, 5).toString());

            JPanel myPanel = new JPanel(new GridLayout(0, 2));
            myPanel.add(new JLabel("ID:"));
            myPanel.add(idField);
            myPanel.add(new JLabel("Nombre:"));
            myPanel.add(nombreField);
            myPanel.add(new JLabel("Jefe:"));
            myPanel.add(jefeField);
            myPanel.add(new JLabel("Lista Empleados:"));
            myPanel.add(listaEmpleadosField);
            myPanel.add(new JLabel("Descripción:"));
            myPanel.add(descripcionField);
            myPanel.add(new JLabel("Gerente:"));
            myPanel.add(gerenteField);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Modificar Departamento", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    long id = Long.parseLong(idField.getText());
                    String nombre = nombreField.getText();
                    String jefe = jefeField.getText();
                    String listaEmpleados = listaEmpleadosField.getText();
                    String descripcion = descripcionField.getText();
                    String gerente = gerenteField.getText();

                    departamentosModel.setValueAt(id, selectedRow, 0);
                    departamentosModel.setValueAt(nombre, selectedRow, 1);
                    departamentosModel.setValueAt(jefe, selectedRow, 2);
                    departamentosModel.setValueAt(listaEmpleados, selectedRow, 3);
                    departamentosModel.setValueAt(descripcion, selectedRow, 4);
                    departamentosModel.setValueAt(gerente, selectedRow, 5);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Por favor, intente de nuevo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un departamento para modificar.");
        }
    }
    //metodo para eliminar departamentos
    private static void deleteDepartament() {
        int selectedRow = departamentosTable.getSelectedRow();
        if (selectedRow != -1) {
            departamentosModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un departamento para eliminar.");
        }
    }
    // metofo para visualizar empleados
    private static void viewEmployees() {
        JFrame frame = new JFrame("Visualización de Empleados");
        frame.setSize(600, 400);
        frame.add(new JScrollPane(empleadosTable));
        frame.setVisible(true);
    }
    //metodo para visualizar reportes
    private static void viewReports() {
        JFrame frame = new JFrame("Visualización de Reportes");
        frame.setSize(600, 400);
        frame.add(new JScrollPane(reportesTable));
        frame.setVisible(true);
    }
    // metodo para crear departamentos
    private static void createDepartament() {
        JTextField idField = new JTextField(5);
        JTextField nombreDepartamentField = new JTextField(5);
        JTextField jefeField = new JTextField(5);
        JTextField listaEmpleadosField = new JTextField(5);
        JTextField descripcionField = new JTextField(5);
        JTextField gerenteField = new JTextField(5);

        JPanel myPanel = new JPanel(new GridLayout(0, 2));
        myPanel.add(new JLabel("Id:"));
        myPanel.add(idField);
        myPanel.add(new JLabel("Nombre departamento:"));
        myPanel.add(nombreDepartamentField);
        myPanel.add(new JLabel("Jefe:"));
        myPanel.add(jefeField);
        myPanel.add(new JLabel("Lista Empleados:"));
        myPanel.add(listaEmpleadosField);
        myPanel.add(new JLabel("Descripcion:"));
        myPanel.add(descripcionField);
        myPanel.add(new JLabel("Gerente:"));
        myPanel.add(gerenteField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Crear Departamento", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                long id = Long.parseLong(idField.getText());
                String nombre = nombreDepartamentField.getText();
                String jefe = jefeField.getText();
                String listaEmpleados = listaEmpleadosField.getText();
                String descripcion = descripcionField.getText();
                String gerente = gerenteField.getText();

                Departamento departamento = new Departamento(id, nombre, jefe, listaEmpleados, descripcion, gerente);
                departamentos.add(departamento);
                departamentosModel.addRow(new Object[]{id, nombre, jefe, listaEmpleados, descripcion, gerente});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Por favor, intente de nuevo.");

            }
        }
    }

    //CREAR METODO PARA CREAR REPORTES CON BOTONES FUNCIONALES
    private static void createReport() {
        JTextField idField = new JTextField(5);
        JTextField empleadosField = new JTextField(5);
        JTextField fechaReporteField = new JTextField(5);
        JTextField puntajeDesempenioField = new JTextField(5);
        JTextField comentarioField = new JTextField(5);
        JTextField departamentoField = new JTextField(5);

        JPanel myPanel = new JPanel(new GridLayout(0, 2));
        myPanel.add(new JLabel("ID:"));
        myPanel.add(idField);
        myPanel.add(new JLabel("Empleados:"));
        myPanel.add(empleadosField);
        myPanel.add(new JLabel("Fecha Reporte:"));
        myPanel.add(fechaReporteField);
        myPanel.add(new JLabel("Puntaje Desempeño:"));
        myPanel.add(puntajeDesempenioField);
        myPanel.add(new JLabel("Comentario:"));
        myPanel.add(comentarioField);
        myPanel.add(new JLabel("Departamento:"));
        myPanel.add(departamentoField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Crear Reporte", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                long id = Long.parseLong(idField.getText());
                String empleados = empleadosField.getText();
                String fechaReporte = fechaReporteField.getText();
                double puntajeDesempenio = Double.parseDouble(puntajeDesempenioField.getText());
                String comentario = comentarioField.getText();
                String departamento = departamentoField.getText();

                ReporteDesempenio reporte = new ReporteDesempenio(id, empleados, fechaReporte, puntajeDesempenio, comentario, departamento);
                reportes.add(reporte);
                reportesModel.addRow(new Object[]{id, empleados, fechaReporte, puntajeDesempenio, comentario, departamento});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Por favor, intente de nuevo.");
            }
        }

    }
}
