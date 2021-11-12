module course.project.tbd {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires junit;

    opens Phase_1.GUI to javafx.fxml;
    exports Phase_1.GUI;

    exports Phase_1.UseCaseClass;


}