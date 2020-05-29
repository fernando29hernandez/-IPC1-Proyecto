package Agenda;
import java.awt.Container;
import java.awt.Desktop;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Menu_201403624 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFileChooser abrirArchivo;
    private Container contenedor = getContentPane();
    private JPanel panel1 = new JPanel();

    public Menu_201403624() {

        iniciador();
    }

    private void iniciador() {
        setForeground(Color.DARK_GRAY);
        setFont(new Font("Dialog", Font.PLAIN, 12));
        setBackground(Color.DARK_GRAY);
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contenedor.add(panel1);
        panel1.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 584, 21);
        panel1.add(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        menuBar.add(mnArchivo);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        JMenu mnCargaArchivo = new JMenu("Carga Archivo");
        mnArchivo.add(mnCargaArchivo);

        JMenuItem mntmExtensiva = new JMenuItem("Extensiva");
        mntmExtensiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cargarextensivamente(arg0);
            }
        });
        mnCargaArchivo.add(mntmExtensiva);

        JMenuItem mntmSustitutiva = new JMenuItem("sustitutiva");
        mntmSustitutiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cargarsustituvamente(arg0);
            }
        });
        mnCargaArchivo.add(mntmSustitutiva);
        mnArchivo.add(mntmSalir);

        JMenu mnContactos = new JMenu("Contactos");
        menuBar.add(mnContactos);

        JMenuItem mntmMenuContactos = new JMenuItem("Menu contactos ");
        mntmMenuContactos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                abrircontactos(arg0);
            }
        });
        mnContactos.add(mntmMenuContactos);

        JMenu mnBusqueda = new JMenu("Busqueda");
        menuBar.add(mnBusqueda);

        JMenuItem mntmRealizarBusqueda = new JMenuItem("Realizar Busqueda por apellido");
        mntmRealizarBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                busqueda_apellido();
            }
        });
        JMenuItem mntmRealizarBusqueda2 = new JMenuItem("Realizar Busqueda por titulo");
        mntmRealizarBusqueda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                busqueda_titulo();
            }
        });
        JMenuItem mntmRealizarBusqueda3 = new JMenuItem("Realizar Busqueda por genero");
        mntmRealizarBusqueda3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                busqueda_genero();
            }
        });
        JMenuItem mntmRealizarBusqueda4 = new JMenuItem("Realizar Busqueda por nacionalidad");
        mntmRealizarBusqueda4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                busqueda_nacionalidad();
            }
        });

        mnBusqueda.add(mntmRealizarBusqueda);
        mnBusqueda.add(mntmRealizarBusqueda2);
        mnBusqueda.add(mntmRealizarBusqueda3);
        mnBusqueda.add(mntmRealizarBusqueda4);
        JMenu mnAyuda = new JMenu("Ayuda");
        menuBar.add(mnAyuda);

        JMenuItem mntmManualDeUsuario = new JMenuItem("Manual de Usuario ");
        mntmManualDeUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File direccion = new File("src/[IPC1]_Junio_Proyecto.pdf");
                    Desktop.getDesktop().open(direccion);
                } catch (IOException ex) {

                }
            }
        });
        mnAyuda.add(mntmManualDeUsuario);

        JLabel lblbienvenida = new JLabel("Bienvenido");
        lblbienvenida.setFont(new Font("Times New Roman", Font.ITALIC, 55));
        lblbienvenida.setBounds(128, 125, 393, 112);
        panel1.add(lblbienvenida);

    }

    public void abrircontactos(ActionEvent e) {
        Contactos_201403624 C = new Contactos_201403624(new JFrame(), true);
        C.setLocationRelativeTo(null);
        C.setVisible(true);

    }

    public void busqueda_apellido() {
        String[] list = {"A-Z", "Z-A"};
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, "Selecciona el tipo de Ordenamiento", JOptionPane.QUESTION_MESSAGE);
        Nodo_201403624[] temporal = Principal_201403624.L.Clonar();
        if (jcb.getSelectedItem().equals("A-Z")) {
            temporal = ordenar_apellido(temporal, 0);
        } else {
            temporal = ordenar_apellido(temporal, 1);
        }

        busquedas b = new busquedas(this, true, temporal);
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }

    public Nodo_201403624[] ordenar_apellido(Nodo_201403624[] temporal, int bandera) {
        for (int i = 0; i < temporal.length - 1; i++) {
            for (int j = 0; j < temporal.length - i - 1; j++) {

                String apellido1 = temporal[j].getApellido();
                String apellido2 = temporal[j + 1].getApellido();
                // --A-Z
                if (bandera == 0) {
                    if (apellido1.compareTo(apellido2) > 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }
                } else {
                    //--Z-A
                    if (apellido1.compareTo(apellido2) < 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }

                }

            }
        }
        return temporal;
    }

    public void busqueda_titulo() {
        String[] list = {"A-Z", "Z-A"};
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, "Selecciona el tipo de Ordenamiento", JOptionPane.QUESTION_MESSAGE);
        Nodo_201403624[] temporal = Principal_201403624.L.Clonar();
        if (jcb.getSelectedItem().equals("A-Z")) {
            temporal = ordenar_apellido(temporal, 0);
            temporal = ordenar_titulo(temporal, 0);
        } else {
            temporal = ordenar_apellido(temporal, 1);
            temporal = ordenar_titulo(temporal, 1);
        }
        busquedas b = new busquedas(this, true, temporal);
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }

    public Nodo_201403624[] ordenar_titulo(Nodo_201403624[] temporal, int bandera) {
        for (int i = 0; i < temporal.length - 1; i++) {
            for (int j = 0; j < temporal.length - i - 1; j++) {

                String apellido1 = temporal[j].getTitulo();
                String apellido2 = temporal[j + 1].getTitulo();
                // --A-Z
                if (bandera == 0) {
                    if (apellido1.compareTo(apellido2) > 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }
                } else {
                    //--Z-A
                    if (apellido1.compareTo(apellido2) < 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }

                }

            }
        }
        return temporal;
    }

    public Nodo_201403624[] ordenar_genero(Nodo_201403624[] temporal, int bandera) {
        for (int i = 0; i < temporal.length - 1; i++) {
            for (int j = 0; j < temporal.length - i - 1; j++) {

                String apellido1 = temporal[j].getGenero();
                String apellido2 = temporal[j + 1].getGenero();
                // --A-Z
                if (bandera == 0) {
                    if (apellido1.compareTo(apellido2) > 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }
                } else {
                    //--Z-A
                    if (apellido1.compareTo(apellido2) < 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }

                }

            }
        }
        return temporal;
    }

    public void busqueda_genero() {
        Nodo_201403624[] temporal = Principal_201403624.L.Clonar();
        String[] generos = {"Femenino", "Masculino"};
        JComboBox jcb_generos = new JComboBox(generos);
        jcb_generos.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb_generos, "Selecciona el tipo de Ordenamiento", JOptionPane.QUESTION_MESSAGE);

        String[] list = {"A-Z", "Z-A"};
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, "Selecciona el tipo de Ordenamiento", JOptionPane.QUESTION_MESSAGE);
        if (jcb.getSelectedItem().equals("A-Z")) {
            temporal = ordenar_apellido(temporal, 0);
            if (jcb_generos.getSelectedItem().equals("Femenino")) {
                temporal = ordenar_genero(temporal, 0);
            } else {
                temporal = ordenar_genero(temporal, 1);
            }
        } else {
            temporal = ordenar_apellido(temporal, 1);
            if (jcb_generos.getSelectedItem().equals("Femenino")) {
                temporal = ordenar_genero(temporal, 0);
            } else {
                temporal = ordenar_genero(temporal, 1);
            }
        }
        busquedas b = new busquedas(this, true, temporal);
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }

    public void busqueda_nacionalidad() {
        String[] list = {"A-Z", "Z-A"};
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, "Selecciona el tipo de Ordenamiento", JOptionPane.QUESTION_MESSAGE);
        Nodo_201403624[] temporal = Principal_201403624.L.Clonar();
        if (jcb.getSelectedItem().equals("A-Z")) {
            temporal = ordenar_apellido(temporal, 0);
            temporal = ordenar_nacionalidad(temporal, 0);
        } else {
            temporal = ordenar_apellido(temporal, 1);
            temporal = ordenar_nacionalidad(temporal, 1);
        }
        busquedas b = new busquedas(this, true, temporal);
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }

    public Nodo_201403624[] ordenar_nacionalidad(Nodo_201403624[] temporal, int bandera) {
        for (int i = 0; i < temporal.length - 1; i++) {
            for (int j = 0; j < temporal.length - i - 1; j++) {

                String apellido1 = temporal[j].getNacionalidad();
                String apellido2 = temporal[j + 1].getNacionalidad();
                // --A-Z
                if (bandera == 0) {
                    if (apellido1.compareTo(apellido2) > 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }
                } else {
                    //--Z-A
                    if (apellido1.compareTo(apellido2) < 0) {
                        Nodo_201403624 temp = temporal[j];
                        temporal[j] = temporal[j + 1];
                        temporal[j + 1] = temp;
                    }

                }

            }
        }
        return temporal;
    }

    public void cargarsustituvamente(ActionEvent e) {

        if (abrirArchivo == null) {
            abrirArchivo = new JFileChooser();
        }
        abrirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = abrirArchivo.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File f = abrirArchivo.getSelectedFile();
            try {
                //String nombre = f.getName();
                String path = f.getAbsolutePath();
                Principal_201403624.L.borrarlista();
                leerarchivo(path);
            } catch (Exception exp) {
            }
        }
    }

    public void cargarextensivamente(ActionEvent e) {

        if (abrirArchivo == null) {
            abrirArchivo = new JFileChooser();
        }
        abrirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int seleccion = abrirArchivo.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File f = abrirArchivo.getSelectedFile();
            try {
                //String nombre = f.getName();
                String path = f.getAbsolutePath();
                leerarchivo(path);
            } catch (Exception exp) {
            }
        }
    }

    private String lineacontacto;
    private String informacion[];

    public void leerarchivo(String direccion) throws ArrayIndexOutOfBoundsException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(direccion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((lineacontacto = br.readLine()) != null) {
                System.out.println(lineacontacto);
                informacion = lineacontacto.split(";");
                Principal_201403624.L.insertarFrente(informacion[2], informacion[1], informacion[0], informacion[3], informacion[4], informacion[5], informacion[6], informacion[7], informacion[8], informacion[9], informacion[10]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
        } finally {
            try {
                if (null != fr) {
                    //br.close();
                    fr.close();
                    JOptionPane.showMessageDialog(null, "carga de contactos exitosa");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo");

            }
        }
    }

}
