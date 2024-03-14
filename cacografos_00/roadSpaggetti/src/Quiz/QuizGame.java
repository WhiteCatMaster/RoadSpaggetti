package Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QuizGame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private JButton quickPlayButton, randomDefinitionButton, galleryButton, exitButton;
    private JLabel scoreLabel;
    private int score = 0;
    private HashMap<String, String> questionsAndAnswers = new HashMap<>();
    private ArrayList<String> questionsAnswered = new ArrayList<>();
    private Random random = new Random();

    public QuizGame() {
        setTitle("Cacografos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        quickPlayButton = new JButton("Partida rápida");
        quickPlayButton.setBounds(50, 30, 150, 30);
        quickPlayButton.addActionListener(this);
        panel.add(quickPlayButton);

        randomDefinitionButton = new JButton("Definición aleatoria");
        randomDefinitionButton.setBounds(50, 80, 150, 30);
        randomDefinitionButton.addActionListener(this);
        panel.add(randomDefinitionButton);

        galleryButton = new JButton("Galería");
        galleryButton.setBounds(50, 130, 150, 30);
        galleryButton.addActionListener(this);
        panel.add(galleryButton);

        exitButton = new JButton("Salir");
        exitButton.setBounds(50, 180, 150, 30);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        scoreLabel = new JLabel("Puntuación: " + score);
        scoreLabel.setBounds(250, 30, 100, 30);
        panel.add(scoreLabel);

        // Agrega preguntas y respuestas
        questionsAndAnswers.put("miedo y rechazo hacia la pobreza y hacia las personas pobres", "Aporofobia");
        questionsAndAnswers.put("cabo de plástico, alambre u hojalata, que se pone a los cordones, agujetas, cintas, etc.", "Errete");
        questionsAndAnswers.put("Híbrido entre un caballo y una asna.","Burdégano");
        questionsAndAnswers.put("Defecación de los excrementos","Deyección");
        questionsAndAnswers.put("Secreción de las glándulas prepuciales. Parte del semen más espesa.","Esmegma");
        questionsAndAnswers.put("Tonto, palurdo, persona quien se emboba con cualquier cosa.","Gaznápiro");
        questionsAndAnswers.put("Persona que interpreta textos, normalmente de carácter religioso o ético, para fijar su verdadero sentido.","Hermeneuta");
        questionsAndAnswers.put("Giro o expresión lingüística que no se ajusta a las reglas gramaticales.","Idiotismo");
        questionsAndAnswers.put("Dicho de un vegetal que no puede marchitarse.","Inmarcesible");
        questionsAndAnswers.put("Lenguaje propio de algunos gremios, es decir, vocabulario especializado en un determinado ámbito profesional.","Jerigonza");
        questionsAndAnswers.put("Joya pequeña","Joyel");
        questionsAndAnswers.put("Sonido excesivamente dulce, suave o delicado","Melifluo");
        questionsAndAnswers.put("Algo que causa repugnancia u horror cuando se habla de ella. Algo que es abominable y asqueroso a partes iguales.","Nefando");
        questionsAndAnswers.put("Persona soñadora, quien se encuentra en la inopia y se mantiene aislada de lo duro y cruel que es este mundo.","Nefelibata");
        questionsAndAnswers.put("Persona enclenque, flaca, desmedrada.","Ñengo");
        questionsAndAnswers.put("Dicho de una persona muy gorda, con buenas nalgas.","Ñomblón");
        questionsAndAnswers.put("Olor que desprende la tierra cuando ésta ha sido mojada por las gotas de la lluvia.","Petricor");
        questionsAndAnswers.put("Dicho de alguien quien ha tenido la mala fortuna de ser excesivamente feo.","Picio");
        questionsAndAnswers.put("Conjunto de objetos metálicos, con poco valor. Pueden ser tijeras, imitaciones de joyas, piezas de coche estropeadas...","Quincalla");
        questionsAndAnswers.put("Dicho de algo que durará para siempre. Algo que tiene inicio, pero no final.","Sempiterno");
        questionsAndAnswers.put("Persona quien es hijo o hija única.","Unigénito");
        questionsAndAnswers.put("Gemido o llanto de un recién nacido.","Vagido");
        questionsAndAnswers.put("Esta palabra sirve para designar a un periodo de 150 años.","Sesquicentenario");
        questionsAndAnswers.put("Soso, insulso e insípido. También dicho para referirse a alguien o algo que resulta ser bastante tonto.","Zonzo");
        // Agrega más preguntas y respuestas aquí...

    }

    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quickPlayButton) {
            playQuickGame();
        } else if (e.getSource() == randomDefinitionButton) {
            showRandomDefinition();
        } else if (e.getSource() == galleryButton) {
            showGallery();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void playQuickGame() {
        int index = random.nextInt(questionsAndAnswers.size());
        String question = (String) questionsAndAnswers.keySet().toArray()[index];
        String answer = questionsAndAnswers.get(question);
        String userAnswer = JOptionPane.showInputDialog(this, question);
        if (userAnswer != null && userAnswer.equalsIgnoreCase(answer)) {
            score++;
            JOptionPane.showMessageDialog(this, "¡Respuesta correcta!");
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta");
        }
        scoreLabel.setText("Puntuación: " + score);
    }

    private void showRandomDefinition() {
        int index = random.nextInt(questionsAndAnswers.size());
        String question = (String) questionsAndAnswers.keySet().toArray()[index];
        String answer = questionsAndAnswers.get(question);
        JOptionPane.showMessageDialog(this, "Pregunta: " + question + "\nRespuesta: " + answer);
    }

    private void showGallery() {
        StringBuilder gallery = new StringBuilder("Galería de respuestas acertadas:\n");
        for (String question : questionsAnswered) {
            String answer = questionsAndAnswers.get(question);
            gallery.append("Pregunta: ").append(question).append(" - Respuesta: ").append(answer).append("\n");
        }
        JOptionPane.showMessageDialog(this, gallery.toString());
    }
}
