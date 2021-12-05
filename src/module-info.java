module course.project.tbd {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires junit;

    opens Phase_2.GUI to javafx.fxml;
    exports Phase_2.GUI;
    exports Phase_2Test;
    exports Phase_2.UseCaseClass;
    exports Phase_2.Entity;

}