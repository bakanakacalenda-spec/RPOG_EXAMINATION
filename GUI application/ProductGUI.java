
    import javax.swing.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

    public class ProductGUI extends JFrame {
        private JTextField txtCustomerName;
        private JComboBox<String> cmbProduct;
        private JTextField txtPrice;

        public ProductGUI() {


            setTitle("Product GUI");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            JLabel lblCustomer = new JLabel("Customer Name:");
            lblCustomer.setBounds(20, 30, 120, 25);
            add(lblCustomer);

            txtCustomerName = new JTextField();
            txtCustomerName.setBounds(150, 30, 200, 25);
            add(txtCustomerName);

            JLabel lblProduct = new JLabel("Select Product:");
            lblProduct.setBounds(20, 80, 120, 25);
            add(lblProduct);

            String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
            cmbProduct = new JComboBox<>(products);
            cmbProduct.setBounds(150, 80, 200, 25);
            add(cmbProduct);

            JLabel lblPrice = new JLabel("Enter Price:");
            lblPrice.setBounds(20, 130, 120, 25);
            add(lblPrice);

            txtPrice = new JTextField();
            txtPrice.setBounds(150, 130, 200, 25);
            add(txtPrice);

            JButton btnProcess = new JButton("PROCESS");
            btnProcess.setBounds(150, 180, 200, 30);
            add(btnProcess);
            JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("File");
            JMenuItem itemExit = new JMenuItem("Exit");
            menuFile.add(itemExit);

            JMenu menuTools = new JMenu("Tools");
            JMenuItem itemProcess = new JMenuItem("Process");
            JMenuItem itemClear = new JMenuItem("Clear");
            menuTools.add(itemProcess);
            menuTools.add(itemClear);

            menuBar.add(menuFile);
            menuBar.add(menuTools);
            setJMenuBar(menuBar);
            btnProcess.addActionListener(e -> processData());
            itemProcess.addActionListener(e -> processData());
            itemExit.addActionListener(e -> System.exit(0));
            itemClear.addActionListener(e -> {
                txtCustomerName.setText("");
                txtPrice.setText("");
                cmbProduct.setSelectedIndex(0);
            });
        }

        private void processData() {
            try {
                String customer = txtCustomerName.getText();
                String product = (String) cmbProduct.getSelectedItem();
                double price = Double.parseDouble(txtPrice.getText());

                ProductCalculations calc = new ProductCalculations(price);
                double vat = calc.GetVat();
                double commission = calc.GetCommission();
                double total = calc.GetTotal();

                String report = "Customer Name: " + customer + "\n" +
                        "Product: " + product + "\n" +
                        "VAT: R " + vat + "\n" +
                        "COMMISSION: R " + commission + "\n" +
                        "TOTAL: R " + total;

                JOptionPane.showMessageDialog(this, report, "Message", JOptionPane.INFORMATION_MESSAGE);
                PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customer);
                writer.println("Product: " + product);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("**************************************************");
                writer.close();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            new ProductGUI().setVisible(true);
        }
    }

