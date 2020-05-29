package Agenda;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Contactos_201403624 extends JDialog {

    private static final long serialVersionUID = 1L;
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
    private JComboBox cmbsexo;
    private JComboBox cmbtitulo;
    private JComboBox cmbnacionalidad;
    private JLabel lblfoto;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Busqueda", "jpg", "png", "gif");
    private String Rutafoto;
    String file;
    String apellido, nombre, titulo, genero, direccion, telefono,
            fecnac, edad, nacionalidad, correo, dirfoto;
    Nodo_201403624 guia = Principal_201403624.L.getInicio();
    int id_contacto = -1;

    public Contactos_201403624(java.awt.Frame padre, boolean aceptar) {

        super(padre, aceptar);
        setBounds(100, 100, 637, 445);
        setTitle("Contactos");
        getContentPane().setLayout(null);
        Rutafoto = "";
        JPanel paneldatos = new JPanel();
        paneldatos.setName("\r\n");
        paneldatos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        paneldatos.setBounds(10, 11, 414, 312);
        getContentPane().add(paneldatos);
        paneldatos.setLayout(null);

        JLabel lblApellidos = new JLabel("Apellido:");
        lblApellidos.setBounds(20, 14, 108, 14);
        paneldatos.add(lblApellidos);

        txtapellido = new JTextField();
        txtapellido.setColumns(10);
        txtapellido.setBounds(127, 14, 269, 20);
        paneldatos.add(txtapellido);

        JLabel lblNombres = new JLabel("Nombre:");
        lblNombres.setBounds(20, 39, 108, 14);
        paneldatos.add(lblNombres);

        txtnombre = new JTextField();
        txtnombre.setColumns(10);
        txtnombre.setBounds(127, 39, 269, 20);
        paneldatos.add(txtnombre);

        JLabel lblTitulo = new JLabel("Titulo:");
        lblTitulo.setBounds(20, 67, 108, 14);
        paneldatos.add(lblTitulo);

        txttitulo = new JTextField();
        txttitulo.setEditable(false);
        txttitulo.setColumns(10);
        txttitulo.setBounds(248, 64, 148, 20);
        paneldatos.add(txttitulo);

        JLabel lblSexo = new JLabel("Genero:");
        lblSexo.setBounds(20, 95, 108, 14);
        paneldatos.add(lblSexo);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(20, 120, 108, 14);
        paneldatos.add(lblDireccion);

        txtdireccion = new JTextField();
        txtdireccion.setColumns(10);
        txtdireccion.setBounds(127, 117, 269, 20);
        paneldatos.add(txtdireccion);

        JLabel lblNewLabel = new JLabel("Telefono:");
        lblNewLabel.setBounds(20, 148, 108, 14);
        paneldatos.add(lblNewLabel);

        txttel = new JTextField();
        txttel.setBounds(127, 145, 269, 20);
        paneldatos.add(txttel);
        txttel.setColumns(10);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setBounds(20, 173, 108, 14);
        paneldatos.add(lblFechaNacimiento);

        txtfecnac = new JTextField();
        txtfecnac.setEditable(false);
        txtfecnac.setColumns(10);
        txtfecnac.setBounds(262, 170, 134, 20);
        paneldatos.add(txtfecnac);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 204, 108, 14);
        paneldatos.add(lblEdad);

        txtedad = new JTextField();
        txtedad.setEditable(false);
        txtedad.setBounds(127, 201, 173, 20);
        paneldatos.add(txtedad);
        txtedad.setColumns(10);

        cmbsexo = new JComboBox();
        cmbsexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                seleccionsexo(arg0);
            }
        });
        cmbsexo.setModel(new DefaultComboBoxModel(new String[]{"Masculino", "Femenino"}));
        cmbsexo.setToolTipText("Seleccione su sexo");
        cmbsexo.setBounds(127, 92, 111, 20);
        paneldatos.add(cmbsexo);

        txtsexo = new JTextField();
        txtsexo.setEditable(false);
        txtsexo.setBounds(248, 92, 148, 20);
        paneldatos.add(txtsexo);
        txtsexo.setColumns(10);

        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        lblNacionalidad.setBounds(20, 235, 86, 14);
        paneldatos.add(lblNacionalidad);

        txtnacionalidad = new JTextField();
        txtnacionalidad.setEditable(false);
        txtnacionalidad.setBounds(248, 232, 148, 20);
        paneldatos.add(txtnacionalidad);
        txtnacionalidad.setColumns(10);

        cmbnacionalidad = new JComboBox();
        cmbnacionalidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarnac(e);
            }
        });
        cmbnacionalidad.setModel(new DefaultComboBoxModel(new String[]{"guatemalteco", "mexicano", "argentino", "noruego", "hungaro", "ruso"}));
        cmbnacionalidad.setToolTipText("Seleccione su Nacionalidad\r\n");
        cmbnacionalidad.setBounds(127, 232, 111, 20);
        paneldatos.add(cmbnacionalidad);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 270, 46, 14);
        paneldatos.add(lblEmail);

        txtcorreo = new JTextField();
        txtcorreo.setBounds(127, 267, 269, 20);
        paneldatos.add(txtcorreo);
        txtcorreo.setColumns(10);

        JButton btnIngreseFecha = new JButton("ingrese fecha");
        btnIngreseFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarfecha(e);
            }
        });
        btnIngreseFecha.setBounds(127, 169, 134, 23);
        paneldatos.add(btnIngreseFecha);

        cmbtitulo = new JComboBox();
        cmbtitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                seccionartitulo(arg0);
            }
        });
        cmbtitulo.setModel(new DefaultComboBoxModel(new String[]{"Sr.", "Sra.", "Ing.", "Dr.", "Lic.", "Bff.", "Otros"}));
        cmbtitulo.setBounds(127, 64, 111, 20);
        paneldatos.add(cmbtitulo);

        JPanel panelfotografia = new JPanel();
        panelfotografia.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Fotografia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelfotografia.setBounds(425, 11, 193, 312);
        getContentPane().add(panelfotografia);
        panelfotografia.setLayout(null);

        lblfoto = new JLabel("");
        lblfoto.setBounds(10, 21, 173, 235);
        panelfotografia.add(lblfoto);

        JButton btnSelecconarImagen = new JButton("Buscar");
        btnSelecconarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarfoto(e);
            }
        });
        btnSelecconarImagen.setBounds(60, 278, 123, 23);
        panelfotografia.add(btnSelecconarImagen);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 330, 608, 75);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnGuardarcontacto = new JButton("Actualizar/Guardar");
        btnGuardarcontacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarcontacto(e);
            }
        });
        btnGuardarcontacto.setBounds(150, 23, 140, 23);
        panel.add(btnGuardarcontacto);

        JButton btnRegresarMenu = new JButton("Regresar Menu");
        btnRegresarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarmenu(e);
            }
        });
        btnRegresarMenu.setBounds(290, 23, 124, 23);
        panel.add(btnRegresarMenu);
        JButton btneliminar = new JButton("Eliminar");
        btneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarcontacto(e);
            }
        });
        btneliminar.setBounds(410, 23, 90, 23);
        panel.add(btneliminar);
        JButton btnlimpiar = new JButton("Nuevo contacto");
        btnlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_contacto = -1;
                txtapellido.setText(null);
                txtnombre.setText(null);
                txttitulo.setText(null);
                txtdireccion.setText(null);
                txttel.setText(null);
                txtfecnac.setText(null);
                txtedad.setText(null);
                txtsexo.setText(null);
                txtnacionalidad.setText(null);
                txtcorreo.setText(null);
                lblfoto.setIcon(null);

            }
        });
        btnlimpiar.setBounds(20, 23, 140, 23);
        panel.add(btnlimpiar);

        JButton btnNewButton = new JButton("<<");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar(e);
                haciaatras();
            }
        });
        btnNewButton.setBounds(500, 23, 50, 23);
        panel.add(btnNewButton);
        JButton btnNewButton2 = new JButton(">>");
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar(e);
                haciadelante();
            }
        });
        btnNewButton2.setBounds(550, 23, 50, 23);
        panel.add(btnNewButton2);

    }

    private void regresarmenu(ActionEvent e) {
        this.setVisible(false);

    }

    private void seccionartitulo(ActionEvent e) {

        txttitulo.setText(null);
        String _titulo = "";

        _titulo = (String) cmbtitulo.getSelectedItem();
        if (_titulo.equals("Otros")) {
            String otrotitulo = JOptionPane.showInputDialog(null, "ingrese su titulo");
            txttitulo.setText(otrotitulo);
        } else {
            txttitulo.setText(_titulo);
        }
    }

    private void seleccionsexo(ActionEvent e) {
        txtsexo.setText(null);
        String _genero = "";
        _genero = (String) cmbsexo.getSelectedItem();
        txtsexo.setText(_genero);
        if (_genero.equals("Masculino")) {
            file = "src/imagen/generoM.jpg";
            ImageIcon fot = new ImageIcon("src/imagen/generoM.jpg");
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
            lblfoto.setIcon(icono);
            lblfoto.repaint();
        } else if (_genero.equals("Femenino")) {
            file = "src/imagen/generoF.jpg";
            ImageIcon fot = new ImageIcon("src/imagen/generoF.jpg");
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
            lblfoto.setIcon(icono);
            lblfoto.repaint();
        }
    }

    private void seleccionarnac(ActionEvent e) {
        txtnacionalidad.setText(null);
        String nac = "";
        nac = (String) cmbnacionalidad.getSelectedItem();
        txtnacionalidad.setText(nac);

    }

    private void seleccionarfoto(ActionEvent e) {
        JFileChooser archivofoto = new JFileChooser();
        archivofoto.setFileFilter(filter);
        int opcion = archivofoto.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String fil = archivofoto.getSelectedFile().getPath();
            file = archivofoto.getSelectedFile().getPath();
            ImageIcon fot = new ImageIcon(fil);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
            lblfoto.setIcon(icono);
            lblfoto.repaint();
            System.out.println(file);

        }
    }

    public Integer calcularEdad(String fecha) {
        Date fechaNac = null;
        try {

            fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaNac);
        int annio = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
        if (mes < 0 || (mes == 0 && dia < 0)) {
            annio--;
        }
        return annio;
    }

    private void ingresarfecha(ActionEvent e) {
        try {
            String messelec = "";
            String[] numerodias = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            JComboBox dia = new JComboBox(numerodias);
            JOptionPane.showMessageDialog(null, dia, "Selcciona el dia ", JOptionPane.INFORMATION_MESSAGE);
            String diaselec = (String) dia.getSelectedItem();
            String[] numeromesesletras = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String[] numeromeses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
            JComboBox meses = new JComboBox(numeromesesletras);
            JOptionPane.showMessageDialog(null, meses, "Selcciona el mes ", JOptionPane.INFORMATION_MESSAGE);
            switch ((String) meses.getSelectedItem()) {
                case "Enero":
                    messelec = numeromeses[0];
                    break;
                case "Febrero":
                    messelec = numeromeses[1];
                    break;
                case "Marzo":
                    messelec = numeromeses[2];
                    break;
                case "Abril":
                    messelec = numeromeses[3];
                    break;
                case "Mayo":
                    messelec = numeromeses[4];
                    break;
                case "Junio":
                    messelec = numeromeses[5];
                    break;
                case "Julio":
                    messelec = numeromeses[6];
                    break;
                case "Agosto":
                    messelec = numeromeses[7];
                    break;
                case "Septiembre":
                    messelec = numeromeses[8];
                    break;
                case "Octubre":
                    messelec = numeromeses[9];
                    break;
                case "Noviembre":
                    messelec = numeromeses[10];
                    break;
                case "Diciembre":
                    messelec = numeromeses[11];
                    break;
                default:
                    break;
            }
            String annio = (String) JOptionPane.showInputDialog(null, "ingrese a�o");
            String fecha = diaselec + "/" + messelec + "/" + annio;
            txtfecnac.setText(fecha);
            txtedad.setText(Integer.toString(calcularEdad(fecha)));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingresa bien la fecha");
        }
    }

    private void eliminarcontacto(ActionEvent e) {
        if (id_contacto != -1) {
            Principal_201403624.L.eliminar(id_contacto);
            guia = Principal_201403624.L.getInicio();
            JOptionPane.showMessageDialog(null, "Contactor Eliminado");
        }

    }

    private void guardarcontacto(ActionEvent e) {
        if (id_contacto != -1) {
            Nodo_201403624 cambio = Principal_201403624.L.buscar(id_contacto);
            if (cambio != null) {
                cambio.setTitulo(txttitulo.getText());
                cambio.setNombre(txtnombre.getText());
                cambio.setApellido(txtapellido.getText());
                cambio.setGenero(txtsexo.getText());
                cambio.setDireccion(txtdireccion.getText());
                cambio.setTelefono(txttel.getText());
                cambio.setFecnac(txtfecnac.getText());
                cambio.setEdad(txtedad.getText());
                cambio.setNacionalidad(txtnacionalidad.getText());
                cambio.setCorreo(txtcorreo.getText());
                cambio.setDirfoto(file);
                JOptionPane.showMessageDialog(null, "Contacto Actulizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            titulo = txttitulo.getText();
            nombre = txtnombre.getText();
            apellido = txtapellido.getText();
            genero = txtsexo.getText();
            direccion = txtdireccion.getText();
            telefono = txttel.getText();
            fecnac = txtfecnac.getText();
            edad = txtedad.getText();
            nacionalidad = txtnacionalidad.getText();
            correo = txtcorreo.getText();
            dirfoto = file;
            Principal_201403624.L.insertarFrente(titulo, nombre, apellido, genero, direccion, telefono, fecnac, edad, nacionalidad, correo, dirfoto);
            JOptionPane.showMessageDialog(null, "Contacto Guardado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            if (guia == null) {
                guia = Principal_201403624.L.getInicio();
            }
        }
    }

    public void haciadelante() {

        if (guia == null) {
            JOptionPane.showMessageDialog(null, "Mensaje", "No existen mas contactos", JOptionPane.INFORMATION_MESSAGE);

        } else {

            if (guia.getSiguiente() != null) {
                guia = guia.getSiguiente();
                id_contacto = guia.getId();
                txtnombre.setText(guia.getNombre());
                txtapellido.setText(guia.getApellido());
                txttitulo.setText(guia.getTitulo());
                txtdireccion.setText(guia.getDireccion());
                txttel.setText(guia.getTelefono());
                txtfecnac.setText(guia.getFecnac());
                txtedad.setText(guia.getEdad());
                txtsexo.setText(guia.getGenero());
                txtnacionalidad.setText(guia.getNacionalidad());
                txtcorreo.setText(guia.getCorreo());
                ImageIcon fot = new ImageIcon(guia.getDirfoto());
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
                lblfoto.setIcon(icono);
                lblfoto.repaint();
                this.repaint();
                
            } else {
                id_contacto = guia.getId();
                txtnombre.setText(guia.getNombre());
                txtapellido.setText(guia.getApellido());
                txttitulo.setText(guia.getTitulo());
                txtdireccion.setText(guia.getDireccion());
                txttel.setText(guia.getTelefono());
                txtfecnac.setText(guia.getFecnac());
                txtedad.setText(guia.getEdad());
                txtsexo.setText(guia.getGenero());
                txtnacionalidad.setText(guia.getNacionalidad());
                txtcorreo.setText(guia.getCorreo());
                ImageIcon fot = new ImageIcon(guia.getDirfoto());
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
                lblfoto.setIcon(icono);
                lblfoto.repaint();
                this.repaint();
                JOptionPane.showMessageDialog(null, "Ultimo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }

    public void haciaatras() {

        if (guia == null) {
            JOptionPane.showMessageDialog(null, "Mensaje", "No existen mas contactos", JOptionPane.INFORMATION_MESSAGE);

        } else {

            if (guia.getAnterior() == null) {
                id_contacto = guia.getId();
                txtnombre.setText(guia.getNombre());
                txtapellido.setText(guia.getApellido());
                txttitulo.setText(guia.getTitulo());
                txtdireccion.setText(guia.getDireccion());
                txttel.setText(guia.getTelefono());
                txtfecnac.setText(guia.getFecnac());
                txtedad.setText(guia.getEdad());
                txtsexo.setText(guia.getGenero());
                txtnacionalidad.setText(guia.getNacionalidad());
                txtcorreo.setText(guia.getCorreo());
                ImageIcon fot = new ImageIcon(guia.getDirfoto());
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
                lblfoto.setIcon(icono);
                this.repaint();
                JOptionPane.showMessageDialog(null, "Primero", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            } else {
                guia = guia.getAnterior();
                id_contacto = guia.getId();
                txtnombre.setText(guia.getNombre());
                txtapellido.setText(guia.getApellido());
                txttitulo.setText(guia.getTitulo());
                txtdireccion.setText(guia.getDireccion());
                txttel.setText(guia.getTelefono());
                txtfecnac.setText(guia.getFecnac());
                txtedad.setText(guia.getEdad());
                txtsexo.setText(guia.getGenero());
                txtnacionalidad.setText(guia.getNacionalidad());
                txtcorreo.setText(guia.getCorreo());
                ImageIcon fot = new ImageIcon(guia.getDirfoto());
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT));
                lblfoto.setIcon(icono);
                this.repaint();
                
            }

        }

    }
}
