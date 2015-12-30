package hu.infokristaly.homework.javafx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;

/**
 * 
 */

/**
 * @author pzoli
 * 
 * Initiated
 * Eclipse How-To
 * http://www.korecky.org/?p=678
 * Tree
 * http://stackoverflow.com/questions/17749099/java-fxml-create-a-tree-with-custom-check-boxes
 * http://docs.oracle.com/javafx/scenebuilder/1/get_started/jsbpub-get_started.htm
 * http://code.makery.ch/java/javafx-8-tutorial-part3/
 * http://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
 * 
 * http://www.caucho.com/resin-3.1/doc/jaxb-annotations.xtp
 * 
 * JavaFX Maven Plugin
 * http://zenjava.com/javafx/maven/
 * 
 */
@SuppressWarnings("restriction")
public class Homework4FXml extends Application { 
    
	@Override
    public void start(final Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Test.fxml"));
        Parent root = (Parent) loader.load();
        TestFxmlController controller = (TestFxmlController) loader.getController();
        controller.setStageAndListeners(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        List<Screen> screens = Screen.getScreens();
        Rectangle2D primScreenBounds;
        if (screens.size()>1) {
            primScreenBounds = screens.get(1).getVisualBounds();
        } else {            
            primScreenBounds = Screen.getPrimary().getVisualBounds();
        }
        primaryStage.setX(primScreenBounds.getMinX() + (primScreenBounds.getWidth() - primaryStage.getWidth()) / 2); 
        primaryStage.setY(primScreenBounds.getMinY() + (primScreenBounds.getHeight() - primaryStage.getHeight()) / 4);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
  
}