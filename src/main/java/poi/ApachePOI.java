package poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class is used to create an arrow in an excel sheet using Apache POI framework.
 */
public class ApachePOI {
    public static void main(String[] args) {
        try  (Workbook wb = new XSSFWorkbook()){
            Sheet sheet = wb.createSheet("Sheet1");
            CreationHelper helper = wb.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(2);
            anchor.setRow1(2);
            anchor.setCol2(20);
            anchor.setRow2(25);
            XSSFSimpleShape shape = ((XSSFDrawing) drawing).createSimpleShape((XSSFClientAnchor) anchor);
            shape.setShapeType(ShapeTypes.RIGHT_ARROW);
            shape.setLineWidth(1.5);
            shape.setLineStyle(0);
            shape.setLineStyleColor(0, 0, 255);
            shape.setFillColor(132,132,132);
            ClientAnchor anchor_rect = helper.createClientAnchor();
            anchor_rect.setCol1(2);
            anchor_rect.setRow1(2);
            anchor_rect.setCol2(4);
            anchor_rect.setRow2(25);
            XSSFSimpleShape shape_rect = ((XSSFDrawing) drawing).createSimpleShape((XSSFClientAnchor) anchor_rect);
            shape_rect.setShapeType(ShapeTypes.ROUND_RECT);
            shape_rect.setLineWidth(1.5);
            shape_rect.setLineStyle(0);
            shape_rect.setLineStyleColor(0, 0, 255);
            shape_rect.setText(new XSSFRichTextString(" * Text 1 \n * Text 2 \n * Text 3"));
            ClientAnchor anchor_rect1 = helper.createClientAnchor();
            anchor_rect1.setCol1(5);
            anchor_rect1.setRow1(2);
            anchor_rect1.setCol2(7);
            anchor_rect1.setRow2(25);
            XSSFSimpleShape shape_rect1 = ((XSSFDrawing) drawing).createSimpleShape((XSSFClientAnchor) anchor_rect1);
            shape_rect1.setShapeType(ShapeTypes.ROUND_RECT);
            shape_rect1.setLineWidth(1.5);
            shape_rect1.setLineStyle(0);
            shape_rect1.setLineStyleColor(0, 0, 255);
            shape_rect1.setText(new XSSFRichTextString(" * Text 1 \n * Text 2 \n * Text 3"));
            FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
            wb.write(fileOut);
        } catch (IOException ioex) {
        }


    }
}
