/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 * com.example.android.justjava
 *
 */

        package com.example.android.justjava;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Editable;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.Checkable;
        import android.widget.EditText;
        import android.widget.TextView;
        import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int precioFinal = 0;
    int precioTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Agregado nuevo metodo experimental con strings */
    public void submitOrder(View view) {
        int precioPorVaso = 5;
        String CadenaFinal;
        precioFinal = obtenerPrecio(cantidad,precioPorVaso);
        CadenaFinal = createOrderSummary(precioFinal);
        displayMessage(CadenaFinal);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Nuevo Metodo de incremento y decremento
     */
    int cantidad = 0;
    public void increment(View view) {
        cantidad =  cantidad + 1;
        displayQuantity(cantidad);
    }

    public void decrement(View view) {
        cantidad = cantidad - 1;
        displayQuantity(cantidad);
    }

    /**
     * Nuevo metodo para calcular el precio del total
     */
    private int obtenerPrecio(int cantidad, int precioPorVaso) {
        precioTotal = cantidad * precioPorVaso;
        return precioTotal;
    }

    /**
     * Metodo para desplegar el resumen de la orden
     *
     */
    public String createOrderSummary(int precioFinal) {
        Boolean estadoWhipped = getCheckedState("Whipped_cream_checkbox");
        Boolean estadoChocolate = getCheckedState("chocolate_checkbox");
        EditText textoNombre = (EditText) findViewById(getResources().getIdentifier("Nombre_Persona",
                "id", getPackageName()));
        Editable name = textoNombre.getText();
        String nombre = "Name: " + name;
        String toppings = "Add whipped cream? " + estadoWhipped;
        String toppings2 = "Add whipped chocolate? " + estadoChocolate;
        String quantityDesplegada = "Quantity: " + cantidad;
        String precio_interno = "Total $" + precioFinal;
        String priceMessage = nombre + "\n" + toppings + "\n"
                + toppings2 +"\n"  + quantityDesplegada + "\n" + precio_interno + "\nThank you!";
        return priceMessage;
    }
    public boolean getCheckedState (String idCheckbox){
        CheckBox EstadoChecked = (CheckBox) findViewById(getResources().getIdentifier(idCheckbox, "id", getPackageName()));
        boolean estadoWhipped = EstadoChecked.isChecked();
        return estadoWhipped;
    }

}
