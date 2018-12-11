/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map_vlaun8th;
import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class Map_VLAUN8th extends Application {

private MapView mapView;

@Override
public void start(Stage stage) {
/// networking VVVV
//System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\carinav1004\\Downloads\\saisd.jks");


/// arcgis VVVV
ArcGISRuntimeEnvironment.setInstallDirectory("/Users/thewebshorty/Downloads/arcgis-runtime-sdk-java-100.4.0");
try {
// create stack pane and application scene
StackPane stackPane = new StackPane();
Scene scene = new Scene(stackPane);

// set title, size, and add scene to stage
stage.setTitle("Display Map Sample");
stage.setWidth(800);
stage.setHeight(700);
stage.setScene(scene);
stage.show();


ArcGISMap map = new ArcGISMap(Basemap.createImagery());
// https://developers.arcgis.com/java/latest/sample-code/set-initial-map-location.htm
//ArcGISMap map = new ArcGISMap(Basemap.Type.NATIONAL_GEOGRAPHIC, 56.075844, -2.681572, 10);
map = new ArcGISMap(Basemap.Type.NATIONAL_GEOGRAPHIC, 29.466588, -98.557563, 11);
// create a ArcGISMap with the a Basemap instance with an Imagery base
// layer

// https://developers.arcgis.com/java/latest/sample-code/set-initial-map-location.htm
//ArcGISMap map = new ArcGISMap(Basemap.Type.NATIONAL_GEOGRAPHIC, 56.075844, -2.681572, 10);
//map = new ArcGISMap(Basemap.Type.NATIONAL_GEOGRAPHIC, 29.466588, -98.557563, 50);

// set the map to be displayed in this view
mapView = new MapView();
mapView.setMap(map);

// add the map view to stack pane
stackPane.getChildren().addAll(mapView);
} catch (Exception e) {
// on any error, display the stack trace.
e.printStackTrace();
}
}

/**
* Stops and releases all resources used in application.
*/
@Override
public void stop() {

if (mapView != null) {
mapView.dispose();
}
}


public static void main(String[] args) {

Application.launch(args);
}

}
