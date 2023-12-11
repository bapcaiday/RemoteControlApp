package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

public class ScreenShotController {

    BufferedImage image;

    @FXML
    private AnchorPane hhh;
    @FXML
    void CaptureScreen(ActionEvent event) throws IOException {
        HelloController.dout.writeUTF("CaptureScreen");
        HelloController.dout.flush();

        byte[] sizeAr = new byte[4];
        int x=HelloController.din.read(sizeAr);


        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
        byte[] imageAr = new byte[size];

        HelloController.din.readFully(imageAr);

        image = ImageIO.read(new ByteArrayInputStream(imageAr));
        System.out.println("Received " + image.getHeight() + "x" + image.getWidth());
        ImageIO.write(image, "jpg", new File("screenshot.jpg"));

        InputStream stream = new FileInputStream("screenshot.jpg");
        Image image1 = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image1);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);

        AnchorPane.setTopAnchor(imageView, 10.0);
        AnchorPane.setLeftAnchor(imageView, 10.0);
        AnchorPane.setRightAnchor(imageView, 10.0);
        AnchorPane.setBottomAnchor(imageView, 50.0);

        hhh.getChildren().add(imageView);
    }

    @FXML
    void DownloadPicture(ActionEvent event) throws IOException {
        if (image!=null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.setInitialDirectory(new File("D://"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Files", "*.jpg"));
            //Show save file dialog
            File file = fileChooser.showSaveDialog(null);
            ImageIO.write(image, "JPG", file);
            image=null;
        }
        else
        {
            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Picture is empty!");
            alert1.showAndWait();
        }

    }

}
