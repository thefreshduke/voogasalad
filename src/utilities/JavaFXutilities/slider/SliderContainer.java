package utilities.JavaFXutilities.slider;

import gameAuthoring.scenes.actorBuildingScenes.behaviorBuilders.SliderInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Purpose of this class is to allow front-end components to easily be able
 * to build labeled sliders.
 * @author Austin Kyker
 *
 */
public class SliderContainer extends VBox {
    
    private Slider mySlider;
    private SliderInfo mySliderInfo;
    private Label myValueLabel;
    
    
    public SliderContainer(String name, double min, double max) {
        super(10);
        mySliderInfo = new SliderInfo(name, min, max);
        resetSlider();
        HBox nameAndValue = new HBox(10);
        myValueLabel = new Label(Double.toString(mySlider.getValue()));
        nameAndValue.getChildren().addAll(new Label(name), myValueLabel);
        this.getChildren().addAll(nameAndValue, mySlider);
    }
    
    public SliderContainer(SliderInfo info) {
        super(10);
        mySliderInfo = info;
        resetSlider();
        HBox sliderAndValue = new HBox(10);
        myValueLabel = new Label(Double.toString(mySlider.getValue()));
        sliderAndValue.getChildren().addAll(mySlider, myValueLabel);
        this.getChildren().addAll(new Label(info.getMyInfo()), sliderAndValue);
    } 
   
    
    public void resetSlider() {
        mySlider = new Slider();
        mySlider.setPrefWidth(120);
        mySlider.setMax(mySliderInfo.getMyMax());
        mySlider.setMin(mySliderInfo.getMyMin());
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                myValueLabel.setText(Double.toString(Math.round(mySlider.getValue()*10)/10.0));
            }
        });
    }

    public double getSliderValue () {
        return mySlider.getValue();
    }
}
