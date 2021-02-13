import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameController{

    @FXML
    private  TextField counterField;

    @FXML
    private Button startButton;

    @FXML
    private GridPane gp;

    @FXML
    private Button done;

    ImageView blankSpace;

    Timer timer;

    int sec;

    ArrayList<ImageView> imageViews;

    public void initialize() throws IOException{

        for(int i=0; i<2; i++) {
            for(int j=0;j<2;j++) {
                ColumnConstraints c = new ColumnConstraints();
                c.setMinWidth(200.00);
                RowConstraints r = new RowConstraints();
                r.setMinHeight(200.0);
                gp.getColumnConstraints().add(c);
                gp.getRowConstraints().add(r);
            }
        }

        String file="src\\herb.jpg";
        BufferedImage bufferedImage= ImageIO.read(new File(file));

        blankSpace = new ImageView();
        blankSpace.addEventHandler(MouseEvent.MOUSE_CLICKED,event ->
        {
            try {
                onMouseClick(event);
            }catch (IOException ex){
                System.out.println(ex);
            }
        });

        imageViews=new ArrayList<>();

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){

                    imageViews.add( new ImageView(SwingFXUtils.toFXImage(bufferedImage.getSubimage( i*200,  j*200, 200, 200),null)));
                    imageViews.get(i*2+j).addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
                        try {
                            onMouseClick(event);
                        }catch (IOException ex){
                            System.out.println(ex);
                        }
                    });
            }
        }

        imageViews.remove(2*2-1);
        imageViews.add(blankSpace);

        showGrid();

    }

    public void showGrid(){
        int i = 0, j = 0;
        for(ImageView imageView : imageViews){
            gp.add(imageView, i, j);
            if(j <1){
                j++;
            } else {
                j = 0;
                i++;
            }
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) throws IOException{
        ImageView imageView=(ImageView)(mouseEvent.getSource());
        if (isNeighbour(imageView,blankSpace)){
            swap(imageView);
        }
    }

    public boolean isNeighbour(ImageView imageView,ImageView blankSpace){
        int colIM=gp.getColumnIndex(imageView);
        int colBS=gp.getColumnIndex(blankSpace);
        int rowIM=gp.getRowIndex(imageView);
        int rowBS=gp.getRowIndex(blankSpace);
        if(Math.abs(colBS - colIM) == 1 && Math.abs(rowBS - rowIM) == 0
                || Math.abs(rowBS - rowIM) == 1 && Math.abs(colBS - colIM) == 0 ) {
            return true;
        }
        return false;
    }

    public void swap(ImageView imageView){
        ImageView pom=new ImageView();

        pom.setImage(imageView.getImage());
        imageView.setImage(blankSpace.getImage());
        blankSpace.setImage(pom.getImage());

        pom = imageView;
        imageView = blankSpace;
        blankSpace = pom;
    }

    public void handle(ActionEvent event) {
        if (event.getSource()==startButton) {
            startButton.setDisable(true);
            sec=0;
            TimerTask timerTask= new TimerTask() {
                @Override
                public void run() {
                        sec++;
                    counterField.setText(sec+"");
                }
            };
            timer= new Timer();
            timer.schedule(timerTask,1000,1000);
        }
    }

    public void endAndSave(ActionEvent event)throws IOException{
        if (event.getSource()==done) {
            timer.cancel();
            zapis("wyniki.txt");
            Pane pane=new Pane();
            Stage window = new Stage();
            Scene scene = new Scene(pane, 300, 300);
            pane.setMaxSize(300,300);
            window.setTitle("Twoje wyniki");
            window.setScene(scene);
            TextArea textArea=new TextArea();
            pane.getChildren().add(textArea);
            textArea.setPrefSize(300,300);
            czytanie("wyniki.txt",textArea);
            window.show();
        }
    }

    public void zapis(String path)throws IOException{
        FileWriter fileWriter = new FileWriter(path, true);
        String x = counterField.getText();
        fileWriter.write("czas: " + x + " s" + "\r");
        fileWriter.close();
    }

    public void czytanie(String path, TextArea textArea)throws IOException{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String s;
            while ((s=bufferedReader.readLine())!=null){
                textArea.appendText(s+"\n");
            }
            fileReader.close();
    }

}