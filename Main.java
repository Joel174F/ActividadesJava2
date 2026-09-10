import javax.swing.*; // Importa los componentes gráficos de Swing para crear la ventana y sus controles.
import java.awt.*; // Importa clases de AWT para layouts y utilidades gráficas.

// La clase Main representa la ventana principal de la aplicación.
public class Main extends JFrame {

    // Campos de texto para ingresar los datos del producto.
    private JTextField txtNombre, txtPrecio, txtStock;
    // Botón que dispara la acción de registrar el producto.
    private JButton btnRegistrar;
    private JButton btnLimpiar;// Boton nuevo para vaciar el formulario
    // Área de texto donde se muestra la información del producto.
    private JTextArea txtResultado;

    // Constructor de la ventana principal.
    public Main() {
      setSize(400, 400); // Define el ancho y alto de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana.*/
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.

        // Etiquetas para indicar qué dato ingresar en cada campo.
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblStock = new JLabel("Stock:");

        // Se crean los campos donde el usuario ingresa nombre, precio y stock.
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        btnRegistrar = new JButton("Registrar"); // Botón para guardar el producto.
        btnLimpiar = new JButton("Limpiar"); // Botón para vaciar el formulario.
        txtResultado = new JTextArea(); // Área para mostrar resultados.
        txtResultado.setEditable(false); // Evita que el usuario modifique el resultado manualmente.

        // Define un diseño en cuadrícula con 6 filas y 2 columnas.
        setLayout(new GridLayout(6, 2, 10, 10));
        add(lblNombre); // Agrega la etiqueta de nombre.
        add(txtNombre); // Agrega el campo de texto del nombre.
        add(lblPrecio); // Agrega la etiqueta de precio.
        add(txtPrecio); // Agrega el campo de texto del precio.
        add(lblStock); // Agrega la etiqueta de stock.
        add(txtStock); // Agrega el campo de texto del stock.
       add(btnLimpiar); // Agrega el botón limpiar.
        add(btnRegistrar); // Agrega el botón registrar.
        add(new JLabel("Resultado:")); // Etiqueta para mostrar el resultado.
        add(new JScrollPane(txtResultado)); // Agrega un scroll para ver el contenido del texto.

        // Cuando se presiona el botón, ejecuta el método registrarProducto.
        btnRegistrar.addActionListener(e -> registrarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        setVisible(true); // Hace visible la ventana.
    }

    // Método que toma los datos ingresados y crea un objeto Producto.
    private void registrarProducto() {
            try{
        String nombre = txtNombre.getText(); // Obtiene el nombre escrito por el usuario.
        double precio = Double.parseDouble(txtPrecio.getText()); // Convierte el texto del precio a double.
        int stock = Integer.parseInt(txtStock.getText()); // Convierte el texto del stock a int.

        Producto producto = new Producto(nombre, precio, stock); // Crea un producto con los datos ingresados.
        txtResultado.setText(producto.mostrarInformacion()); // Muestra la información del producto en el área de texto.
    } 

    // Salta si el precio o el stock no son numeros validos
    catch (NumberFormatException ex ){
        JOptionPane.showMessageDialog(this ,
            " El precio y el stock deben ser valores numericos .",
            "Error de formato",
            JOptionPane.ERROR_MESSAGE);
        
    }
    // Salta si Producto rechaza los datos (nombre vacio, negativos)
    catch (IllegalArgumentException ex) {

     JOptionPane.showMessageDialog(this ,
        ex.getMessage(),
        "Datos invalidos",
        JOptionPane.ERROR_MESSAGE);
    }
}
    // Elimina los datos del formulario

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtResultado.setText("");
    }

    // Método principal que inicia la aplicación.
    public static void main(String[] args) {
        new Main(); // Crea una instancia de la ventana principal.
    }
}


    




 




    
