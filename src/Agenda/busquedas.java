package Agenda;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class busquedas extends JDialog {

    @SuppressWarnings("FieldMayBeFinal")
    private JTextField txtapellido;
    private JTextField txtnombre;
    private JTextField txttitulo;
    private JTextField txtdireccion;
    private JTextField txttel;
    private JTextField txtfecnac;
    private JTextField txtedad;
    private JTextField txtsexo;
    private JTextField txtnacionalidad;
    private JTextField txtcorreo;
    private Nodo_201403624[] lista;
    private int pivote = 0;

    public busquedas(java.awt.Frame padre, boolean aceptar, Nodo_201403624[] lista) {
        this.lista = lista;
        setBounds(100, 100, 610, 410);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 429, 311);
        panel.setLayout(null);
        panel.setName("\r\n");
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(panel);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 14, 108, 14);
        panel.add(lblApellido);

        txtapellido = new JTextField();
        txtapellido.setColumns(10);
        txtapellido.setBounds(127, 14, 269, 20);
        panel.add(txtapellido);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 39, 108, 14);
        panel.add(lblNombre);

        txtnombre = new JTextField();
        txtnombre.setColumns(10);
        txtnombre.setBounds(127, 39, 269, 20);
        panel.add(txtnombre);

        JLabel label_2 = new JLabel("Titulo:");
        label_2.setBounds(20, 64, 108, 14);
        panel.add(label_2);

        txttitulo = new JTextField();
        txttitulo.setColumns(10);
        txttitulo.setBounds(127, 64, 269, 20);
        panel.add(txttitulo);

        JLabel label_3 = new JLabel("Genero:");
        label_3.setBounds(20, 95, 108, 14);
        panel.add(label_3);

        JLabel label_4 = new JLabel("Direccion:");
        label_4.setBounds(20, 120, 108, 14);
        panel.add(label_4);

        txtdireccion = new JTextField();
        txtdireccion.setColumns(10);
        txtdireccion.setBounds(127, 117, 269, 20);
        panel.add(txtdireccion);

        JLabel label_5 = new JLabel("Telefono:");
        label_5.setBounds(20, 148, 108, 14);
        panel.add(label_5);

        txttel = new JTextField();
        txttel.setColumns(10);
        txttel.setBounds(127, 145, 269, 20);
        panel.add(txttel);

        JLabel label_6 = new JLabel("Fecha Nacimiento:");
        label_6.setBounds(20, 173, 108, 14);
        panel.add(label_6);

        txtfecnac = new JTextField();
        txtfecnac.setEditable(false);
        txtfecnac.setColumns(10);
        txtfecnac.setBounds(127, 173, 134, 20);
        panel.add(txtfecnac);

        JLabel label_7 = new JLabel("Edad:");
        label_7.setBounds(20, 204, 108, 14);
        panel.add(label_7);

        txtedad = new JTextField();
        txtedad.setEditable(false);
        txtedad.setColumns(10);
        txtedad.setBounds(127, 201, 173, 20);
        panel.add(txtedad);

        txtsexo = new JTextField();
        txtsexo.setEditable(false);
        txtsexo.setColumns(10);
        txtsexo.setBounds(127, 89, 148, 20);
        panel.add(txtsexo);

        JLabel label_8 = new JLabel("Nacionalidad:");
        label_8.setBounds(20, 235, 86, 14);
        panel.add(label_8);

        txtnacionalidad = new JTextField();
        txtnacionalidad.setEditable(false);
        txtnacionalidad.setColumns(10);
        txtnacionalidad.setBounds(127, 232, 148, 20);
        panel.add(txtnacionalidad);

        JLabel label_9 = new JLabel("Email:");
        label_9.setBounds(20, 270, 46, 14);
        panel.add(label_9);

        txtcorreo = new JTextField();
        txtcorreo.setColumns(10);
        txtcorreo.setBounds(127, 267, 269, 20);
        panel.add(txtcorreo);

        JButton btnMostrar = new JButton("Mostrar Reporte");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mostrardatos(arg0);
            }
        });
        btnMostrar.setBounds(439, 177, 150, 23);
        JButton btnNewButton = new JButton("<<");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar(e);
                mostrarhaciaatras();
            }
        });
        btnNewButton.setBounds(470, 140, 50, 23);
        JButton btnNewButton2 = new JButton(">>");
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar(e);
                mostrarhaciadelante();
            }
        });
        btnNewButton2.setBounds(520, 140, 50, 23);

        getContentPane().add(btnMostrar);
        getContentPane().add(btnNewButton);
        getContentPane().add(btnNewButton2);

    }

    public void mostrarhaciadelante() {
        if (pivote + 1 < this.lista.length) {
            pivote++;
            txtapellido.setText(lista[pivote].getApellido());
            txtnombre.setText(lista[pivote].getNombre());
            txttitulo.setText(lista[pivote].getTitulo());
            txtsexo.setText(lista[pivote].getGenero());
            txtdireccion.setText(lista[pivote].getDireccion());
            txttel.setText(lista[pivote].getTelefono());
            txtfecnac.setText(lista[pivote].getFecnac());
            txtedad.setText(lista[pivote].getEdad());
            txtnacionalidad.setText(lista[pivote].getNacionalidad());
            txtcorreo.setText(lista[pivote].getCorreo());
        } else {
            JOptionPane.showMessageDialog(null, "Ultimo registro");
        }
    }

    public void mostrarhaciaatras() {
        if (pivote - 1 >= 0) {
            pivote--;
            txtapellido.setText(lista[pivote].getApellido());
            txtnombre.setText(lista[pivote].getNombre());
            txttitulo.setText(lista[pivote].getTitulo());
            txtsexo.setText(lista[pivote].getGenero());
            txtdireccion.setText(lista[pivote].getDireccion());
            txttel.setText(lista[pivote].getTelefono());
            txtfecnac.setText(lista[pivote].getFecnac());
            txtedad.setText(lista[pivote].getEdad());
            txtnacionalidad.setText(lista[pivote].getNacionalidad());
            txtcorreo.setText(lista[pivote].getCorreo());
        } else {
            JOptionPane.showMessageDialog(null, "Primer registro");
        }

    }

    public void mostrardatos(ActionEvent e) {
        String html = "<html><head></head><body>";
        html += "<table><tr>"
                + "<th>No.</th>"
                + "<th>Apellido</th>"
                + "<th>Nombre</th>"
                + "<th>Titulo</th>"
                + "<th>Genero</th>"
                + "<th>Direccion</th>"
                + "<th>Telefono</th>"
                + "<th>Correo</th>"
                + "<th>Fechas Nacimiento</th>"
                + "<th>Edad</th>"
                + "<th>Nacionalidad</th>";
        html += "</tr>";

        for (int i = 0; i < lista.length; i++) {
            html += "<tr>";
            html += "<td>" + i + "</td>";

            html += "<td>" + lista[i].getApellido() + "</td>";
            html += "<td>" + lista[i].getNombre() + "</td>";
            html += "<td>" + lista[i].getTitulo() + "</td>";

            html += "<td>" + lista[i].getGenero() + "</td>";

            html += "<td>" + lista[i].getDireccion() + "</td>";

            html += "<td>" + lista[i].getTelefono() + "</td>";
            html += "<td>" + lista[i].getCorreo() + "</td>";

            html += "<td>" + lista[i].getFecnac() + "</td>";

            html += "<td>" + lista[i].getEdad() + "</td>";

            html += "<td>" + lista[i].getNacionalidad() + "</td>";

            html += "</tr>";
        }
        html += "</table></body></html>";
        try {
            FileWriter myWriter = new FileWriter("reporte.html");
            myWriter.write(html);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");

        }
    }

    public JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxttitulo() {
        return txttitulo;
    }

    public void setTxttitulo(JTextField txttitulo) {
        this.txttitulo = txttitulo;
    }

    public JTextField getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(JTextField txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public JTextField getTxttel() {
        return txttel;
    }

    public void setTxttel(JTextField txttel) {
        this.txttel = txttel;
    }

    public JTextField getTxtfecnac() {
        return txtfecnac;
    }

    public void setTxtfecnac(JTextField txtfecnac) {
        this.txtfecnac = txtfecnac;
    }

    public JTextField getTxtedad() {
        return txtedad;
    }

    public void setTxtedad(JTextField txtedad) {
        this.txtedad = txtedad;
    }

    public JTextField getTxtsexo() {
        return txtsexo;
    }

    public void setTxtsexo(JTextField txtsexo) {
        this.txtsexo = txtsexo;
    }

    public JTextField getTxtnacionalidad() {
        return txtnacionalidad;
    }

    public void setTxtnacionalidad(JTextField txtnacionalidad) {
        this.txtnacionalidad = txtnacionalidad;
    }

    public JTextField getTxtcorreo() {
        return txtcorreo;
    }

    public void setTxtcorreo(JTextField txtcorreo) {
        this.txtcorreo = txtcorreo;
    }

    public Nodo_201403624[] getLista() {
        return lista;
    }

    public void setLista(Nodo_201403624[] lista) {
        this.lista = lista;
    }

    public int getPivote() {
        return pivote;
    }

    public void setPivote(int pivote) {
        this.pivote = pivote;
    }
}
