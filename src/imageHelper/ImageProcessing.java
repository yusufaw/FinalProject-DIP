package imageHelper;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageProcessing {

    private ArrayList koordObjek;
    private BufferedImage realImage;
    private BufferedImage grayImage;
    private BufferedImage binaryImage;
    private int tinggiCitra;
    private int lebarCitra;
    private int maxGray;
    private int jumlahHuman = 0;

    /**
     * Konstruktor
     */
    public ImageProcessing() {
        this.realImage = null;
        this.grayImage = null;
        this.binaryImage = null;
        this.koordObjek = new ArrayList();
        this.lebarCitra = 0;
        this.tinggiCitra = 0;
        this.maxGray = 0;
    }

    /**
     * Tentukan image yg akan di proses.
     *
     * @param input
     */
    public void setImage(BufferedImage input) {
        this.realImage = input;
        this.grayImage = null;
        this.setSize();
    }

    /**
     * Dapatkan image yg asli.
     *
     * @return
     */
    public BufferedImage getImage() {
        return this.realImage;
    }

    /**
     * Dapatkan image yg sudah diproses menjadi grayscale.
     *
     * @return
     */
    public BufferedImage getGrayImage() {
        return this.grayImage;
    }

    
    /**
     * Dapatkan image yg sudah diproses menjadi binary image.
     *
     * @return
     */
    public BufferedImage getBinaryImage() {
        return this.binaryImage;
    }

    /**
     * Dapatkan nilai max gray
     *
     * @return
     */
    public int getMaxGray() {
        return this.maxGray;
    }

    /**
     * Mendapatkan dimensi lebar dari image.
     *
     * @return
     */
    public int getLebar() {
        return this.lebarCitra;
    }

    /**
     * Mendapatkan dimensi tinggi dari image.
     *
     * @return
     */
    public int getTinggi() {
        return this.tinggiCitra;
    }

    /**
     * Dapatkan ukuran image, dari image asli.
     */
    private void setSize() {
        this.tinggiCitra = realImage.getHeight();
        this.lebarCitra = realImage.getWidth();
    }

    /**
     * Mendapatkan nilai jumlah manusia
     * @return 
     */
    public int getJumlahHuman() {
        return jumlahHuman;
    }

    /**
     * Pemrosesan image menjadi grayscale image.
     *
     * @param metode : metode grayscale
     */
    public void imageToGray(int metode) {
        double red, green, blue;
        int gray = 0;
        Color before, after;

        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < tinggiCitra; y++) {
            for (int x = 0; x < lebarCitra; x++) {
                before = new Color(realImage.getRGB(x, y) & 0x00ffffff);
                if (metode == 0) { // Lightness
                    red = (double) (before.getRed());
                    green = (double) (before.getGreen());
                    blue = (double) (before.getBlue());
                    gray = (int) ((Math.max(green, Math.max(red, blue)) + Math.min(green, Math.min(red, blue))) / 2);
                } else if (metode == 1) { // Average
                    red = (double) (before.getRed());
                    green = (double) (before.getGreen());
                    blue = (double) (before.getBlue());
                    gray = (int) ((red + green + blue) / 2);
                } else if (metode == 2) { // Luminosity
                    red = (double) (before.getRed() * 0.2989);
                    green = (double) (before.getGreen() * 0.5870);
                    blue = (double) (before.getBlue() * 0.1140);
                    gray = (int) (red + green + blue);
                }
                maxGray = gray > maxGray ? gray : maxGray;
                gray = gray < 0 ? 0 : gray;
                gray = gray > 255 ? 255 : gray;
                after = new Color(gray, gray, gray);
                output.setRGB(x, y, after.getRGB());
            }
        }
        this.grayImage = output;
    }

    

    /**
     * Pemrosesan image menjadi binary image.
     */
    public void imageToBinary() {
        Color before, after;
        koordObjek.clear();

        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < tinggiCitra; y++) {
            for (int x = 0; x < lebarCitra; x++) {

                before = new Color(this.grayImage.getRGB(x, y) & 0x00ffffff);

                if (before.getBlue() < 100) {
                    after = new Color(0, 0, 0);
                    koordObjek.add(String.valueOf(x) + "," + String.valueOf(y));
                } else {
                    after = new Color(255, 255, 255);
                }
                output.setRGB(x, y, after.getRGB());
            }
        }
        this.binaryImage = output;
    }

    /**
     * Pemrosesan image substraction dari 2 gambar
     *
     * @param gambar2 : gambar ke 2 yang ingin dibandingkan
     * @return BufferedImage : gambar hasil dari image substraction
     */
    public BufferedImage imageSubstraction(BufferedImage gambar2) {
        Color before, after, before2;
        int hasil;
        koordObjek.clear();
        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < tinggiCitra; y++) {
            for (int x = 0; x < lebarCitra; x++) {
                before = new Color(this.grayImage.getRGB(x, y) & 0x00ffffff);
                before2 = new Color(gambar2.getRGB(x, y) & 0x00ffffff);
                hasil = (int) ((before.getRed() - before2.getRed()));
                hasil = hasil < 0 ? (int) (Math.sqrt(Math.pow(hasil, 2))) : hasil;
                hasil = hasil > 255 ? 255 : hasil;
                after = new Color(hasil, hasil, hasil);
                output.setRGB(x, y, after.getRGB());
            }
        }
        return output;
    }

    public BufferedImage erosi(BufferedImage gambar) {
        Color after;
        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_BYTE_GRAY);
        int hasil[] = new int[9];
        for (int y = 1; y < tinggiCitra - 1; y++) {
            for (int x = 1; x < lebarCitra - 1; x++) {
                hasil[0] = setErosi(new Color(gambar.getRGB(x - 1, y - 1) & 0x00ffffff));
                hasil[1] = setErosi(new Color(gambar.getRGB(x, y - 1) & 0x00ffffff));
                hasil[2] = setErosi(new Color(gambar.getRGB(x + 1, y - 1) & 0x00ffffff));
                hasil[3] = setErosi(new Color(gambar.getRGB(x - 1, y) & 0x00ffffff));
                hasil[4] = setErosi(new Color(gambar.getRGB(x, y) & 0x00ffffff));
                hasil[5] = setErosi(new Color(gambar.getRGB(x + 1, y) & 0x00ffffff));
                hasil[6] = setErosi(new Color(gambar.getRGB(x - 1, y + 1) & 0x00ffffff));
                hasil[7] = setErosi(new Color(gambar.getRGB(x, y + 1) & 0x00ffffff));
                hasil[8] = setErosi(new Color(gambar.getRGB(x + 1, y + 1) & 0x00ffffff));
                if (hasil[0] == 0) {
                    after = new Color(0, 0, 0);
                } else {
                    if (hasil[1] == 0) {
                        after = new Color(0, 0, 0);
                    } else {
                        if (hasil[2] == 0) {
                            after = new Color(0, 0, 0);
                        } else {
                            if (hasil[3] == 0) {
                                after = new Color(0, 0, 0);
                            } else {
                                if (hasil[4] == 0) {
                                    after = new Color(0, 0, 0);
                                } else {
                                    if (hasil[5] == 0) {
                                        after = new Color(0, 0, 0);
                                    } else {
                                        if (hasil[6] == 0) {
                                            after = new Color(0, 0, 0);
                                        } else {
                                            if (hasil[7] == 0) {
                                                after = new Color(0, 0, 0);
                                            } else {
                                                if (hasil[8] == 0) {
                                                    after = new Color(0, 0, 0);
                                                } else {
                                                    after = new Color(255, 255, 255);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                output.setRGB(x, y, after.getRGB());
            }
        }
        return output;
    }

    public int setErosi(Color c) {
        if (c.getRed() == 0) {
            return 0;
        }
        return 255;
    }
    
    public BufferedImage dilasi(BufferedImage gambar) {
        Color after;
        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_BYTE_GRAY);
        int hasil[] = new int[9];
        for (int y = 1; y < tinggiCitra - 1; y++) {
            for (int x = 1; x < lebarCitra - 1; x++) {
                hasil[0] = setErosi(new Color(gambar.getRGB(x - 1, y - 1) & 0x00ffffff));
                hasil[1] = setErosi(new Color(gambar.getRGB(x, y - 1) & 0x00ffffff));
                hasil[2] = setErosi(new Color(gambar.getRGB(x + 1, y - 1) & 0x00ffffff));
                hasil[3] = setErosi(new Color(gambar.getRGB(x - 1, y) & 0x00ffffff));
                hasil[4] = setErosi(new Color(gambar.getRGB(x, y) & 0x00ffffff));
                hasil[5] = setErosi(new Color(gambar.getRGB(x + 1, y) & 0x00ffffff));
                hasil[6] = setErosi(new Color(gambar.getRGB(x - 1, y + 1) & 0x00ffffff));
                hasil[7] = setErosi(new Color(gambar.getRGB(x, y + 1) & 0x00ffffff));
                hasil[8] = setErosi(new Color(gambar.getRGB(x + 1, y + 1) & 0x00ffffff));
                if (hasil[0] == 255) {
                    after = new Color(255, 255, 255);
                } else {
                    if (hasil[1] == 255) {
                        after = new Color(255, 255, 255);
                    } else {
                        if (hasil[2] == 255) {
                            after = new Color(255, 255, 255);
                        } else {
                            if (hasil[3] == 255) {
                                after = new Color(255, 255, 255);
                            } else {
                                if (hasil[4] == 255) {
                                    after = new Color(255, 255, 255);
                                } else {
                                    if (hasil[5] == 255) {
                                        after = new Color(255, 255, 255);
                                    } else {
                                        if (hasil[6] == 255) {
                                            after = new Color(255, 255, 255);
                                        } else {
                                            if (hasil[7] == 255) {
                                                after = new Color(255, 255, 255);
                                            } else {
                                                if (hasil[8] == 255) {
                                                    after = new Color(255, 255, 255);
                                                } else {
                                                    after = new Color(0, 0, 0);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                output.setRGB(x, y, after.getRGB());
            }
        }
        return output;
    }

    public BufferedImage setBorderObject(BufferedImage gambar) {
        Color before;
        int temuXkanan, temuXkiri, temuYatas, temuYbawah;
        koordObjek.clear();
        BufferedImage output = new BufferedImage(lebarCitra, tinggiCitra,
                BufferedImage.TYPE_3BYTE_BGR);
        outloopXKiri:
        for (temuXkiri = 0; temuXkiri < lebarCitra; temuXkiri++) {
            for (int y = 0; y < tinggiCitra; y++) {
                before = new Color(gambar.getRGB(temuXkiri, y) & 0x00ffffff);
                if (before.getRed() == 0) {
                    break outloopXKiri;
                }
            }
        }
        outloopXKanan:
        for (temuXkanan = (lebarCitra - 1); temuXkanan > 0; temuXkanan--) {
            for (int y = 0; y < tinggiCitra; y++) {
                before = new Color(gambar.getRGB(temuXkanan, y) & 0x00ffffff);
                if (before.getRed() == 0) {
                    break outloopXKanan;
                }
            }
        }

        outloopYAtas:
        for (temuYatas = 0; temuYatas < tinggiCitra; temuYatas++) {
            for (int x = 0; x < lebarCitra; x++) {
                before = new Color(gambar.getRGB(x, temuYatas) & 0x00ffffff);
                if (before.getRed() == 0) {
                    break outloopYAtas;
                }
            }
        }
        outloopYBawah:
        for (temuYbawah = (tinggiCitra - 1); temuYbawah > 0; temuYbawah--) {
            for (int x = 0; x < lebarCitra; x++) {
                before = new Color(gambar.getRGB(x, temuYbawah) & 0x00ffffff);
                if (before.getRed() == 0) {
                    break outloopYBawah;
                }
            }
        }
        
        Graphics gr = output.getGraphics();
        Graphics2D g2d = (Graphics2D) gr.create();
        g2d.setColor(Color.green);
        g2d.fillRect(0, 0, output.getWidth(), output.getHeight());
        g2d.drawImage(this.getImage(), 0, 0, null);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(temuXkiri, temuYatas, temuXkanan, temuYatas);
        g2d.drawLine(temuXkiri, temuYatas, temuXkiri, temuYbawah);
        g2d.drawLine(temuXkiri, temuYbawah, temuXkanan, temuYbawah);
        g2d.drawLine(temuXkanan, temuYatas, temuXkanan, temuYbawah);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(output.getWidth() / 2, 0, output.getWidth() / 2, output.getHeight());
        if (temuXkiri > (output.getWidth() / 2) - 20 && temuXkiri < (output.getWidth() / 2) + 20) {
            jumlahHuman += 1;
        }
        return output;
    }
}
