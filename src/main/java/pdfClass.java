import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

    public class pdfClass {
        private static final String fileName = "test.pdf";

        public static void main(String[] args) {
            writeUsingItext();
            test3();
            createPdf();
        }

        private static void writeUsingItext() {
            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));

                document.open();

                Paragraph p = new Paragraph();
                p.add("First Paragraph");
                p.setAlignment(Element.ALIGN_CENTER);

                document.add(p);

                Paragraph p2 = new Paragraph();
                p2.add("This is my paragraph 2"); //no alignment

                document.add(p2);

                Font f = new Font();
                f.setStyle(Font.BOLD);
                f.setSize(8);

                document.add(new Paragraph("This is my paragraph 3", f));

                //close
                document.close();

                System.out.println("Done");
            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void createPdf() {
            try {
                String projectDir = System.getProperty("user.dir");
                System.out.println(projectDir);
                Image img = Image.getInstance("abc.png");
                Document doc = new Document(PageSize.A4, 20, 20, 20, 20 );
                PdfWriter.getInstance(doc, new FileOutputStream("Test2.pdf"));
                doc.open();

                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100);
                img.scalePercent(4);

//                table.setWidths(new int[]{1, 2});
//                table.addCell(img);
                PdfPTable table1 = new PdfPTable(1);
                table1.setWidthPercentage(100);

                PdfPCell border = new PdfPCell(new Phrase(" "));
                border.setBackgroundColor(BaseColor.CYAN);
                border.setBorder(Rectangle.NO_BORDER);
                table1.addCell(border);


                PdfPCell cx = new PdfPCell(img);
                cx.setBorder(Rectangle.NO_BORDER);
                table.addCell(cx);

                Font fe = new Font();
                fe.setStyle(Font.BOLD);
                fe.setSize(25);
                PdfPCell cq = new PdfPCell(new Phrase("\n\nReport Katalon", fe));
                cq.setHorizontalAlignment(Element.ALIGN_CENTER);
                cq.setVerticalAlignment(Element.ALIGN_CENTER);
                cq.setBorder(Rectangle.NO_BORDER);
                table.addCell(cq);

                Image img2 = Image.getInstance("asd.png");
                img2.scalePercent(10);
                PdfPCell cqw = new PdfPCell(img2);
                cqw.setBorder(Rectangle.NO_BORDER);
                cqw.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cqw);

                Paragraph pa1 = new Paragraph();
                Font fr = new Font();
                fr.setStyle(Font.BOLD);
                fr.setStyle(Font.UNDERLINE);
                fr.setSize(18);

                pa1.add("\nCONTOH NAMA NEW TEST SUITES");
                pa1.setAlignment(Element.ALIGN_CENTER);
                pa1.setFont(fr);

                doc.add(table);
                doc.add(table1);
                doc.add(pa1);
                doc.close();

                System.out.print("Clear");
            } catch (DocumentException ez) {
                ez.printStackTrace();
            } catch (IOException ez) {
                ez.printStackTrace();
            }
        }

        public static void test3() {
            try{
                Document dox = new Document(PageSize.A4, 20, 20, 20,20 );

                PdfPTable tab = new PdfPTable(3);
//                float widhts[] = {3, 6, 3};
                tab.setWidths(new float[]{3,6,3});
                tab.setHeaderRows(1);

                PdfPCell ce = new PdfPCell(new Phrase("Emp Id"));
                ce.setBackgroundColor(new BaseColor(0, 173, 239));
                tab.addCell(ce);

                ce = new PdfPCell(new Phrase("Emp Name"));
                ce.setBackgroundColor(new BaseColor(0, 173, 239));
                tab.addCell(ce);

                ce = new PdfPCell(new Phrase("Emp Name"));
                ce.setBackgroundColor(new BaseColor(0, 173, 239));
                tab.addCell(ce);

                ce = new PdfPCell(new Phrase("Salary"));
                ce.setBackgroundColor(new BaseColor(0, 173, 239));
                tab.addCell(ce);

                Phrase ph;
                for (int ctr = 1; ctr <= 4; ctr++){
                    ce = new PdfPCell();
//
                    Font f = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
                    ph = new Phrase("WS-" + ctr);
                    ce.addElement(ph);
                    tab.addCell(ce);

                    ce = new PdfPCell();
                    ph = new Phrase("Sandeep Sharma " + ctr);
                    ce.addElement(ph);
                    tab.addCell(ph);

                    ce = new PdfPCell();
                    ph = new Phrase("2000" + ctr);
                    ce.addElement(ph);
                    tab.addCell(ce);
                }
                PdfWriter.getInstance(dox, new FileOutputStream("EmployeeData.pdf"));
                dox.open();
                dox.add(tab);
                dox.close();
                System.out.println("Successfull.");
            }catch (FileNotFoundException | DocumentException ew){
                ew.printStackTrace();
            }catch (IOException ew){
                ew.printStackTrace();
            }
        }
    }