import java.util.Map;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class ImageLoader {

    private Map<String,ImageIcon> loadImage;

    private static final String local = System.getProperty("user.dir");
    
    private static final String bgroundPath = local + "/image/background.png";
    private static final String canvasPath = local + "/image/canvas.png";
    private static final String logoPath = local + "/image/logo.png";
    
    private static final String drawCanvas = local + "/image/draw.png";
    private static final String clearCanvas = local + "/image/clearCanvas.png";
    
    private static final String saveScript = local + "/image/save.png";
    private static final String loadScript = local + "/image/open.png";
    private static final String addScript = local + "/image/add.png";
    private static final String clearScript = local + "/image/clearScript.png";
    
    private static final String addPoint = local + "/image/point.png";
    private static final String addSpeed = local + "/image/speed.png";

    private static final String drawCanvasHov = local + "/image/drawHov.png";
    private static final String clearCanvasHov = local + "/image/clearCanvasHov.png";
    
    private static final String saveScriptHov = local + "/image/saveHov.png";
    private static final String loadScriptHov = local + "/image/openHov.png";
    private static final String addScriptHov = local + "/image/addHov.png";
    private static final String clearScriptHov = local + "/image/clearScriptHov.png";
    
    private static final String addPointHov = local + "/image/pointHov.png";
    private static final String addSpeedHov = local + "/image/speedHov.png";

    private static final String drawCanvasPress = local + "/image/drawPress.png";
    private static final String clearCanvasPress = local + "/image/clearCanvasPress.png";
    
    private static final String saveScriptPress = local + "/image/savePress.png";
    private static final String loadScriptPress = local + "/image/openPress.png";
    private static final String addScriptPress = local + "/image/addPress.png";
    private static final String clearScriptPress = local + "/image/clearScriptPress.png";
    
    private static final String addPointPress = local + "/image/pointPress.png";
    private static final String addSpeedPress = local + "/image/speedPress.png"; 
    
    private static final String textBackground = local + "/image/graph.png";
    
    
    private static final ImageIcon bground = new ImageIcon(bgroundPath);
    private static final ImageIcon canvas = new ImageIcon(canvasPath);
    private static final ImageIcon logoType = new ImageIcon(logoPath);
    
    private static final ImageIcon draw = new ImageIcon(drawCanvas);
    private static final ImageIcon clear = new ImageIcon(clearCanvas);
    
    private static final ImageIcon save = new ImageIcon(saveScript);
    private static final ImageIcon load = new ImageIcon(loadScript);
    private static final ImageIcon add = new ImageIcon(addScript);
    private static final ImageIcon clearScr = new ImageIcon(clearScript);
    
    private static final ImageIcon point = new ImageIcon(addPoint);
    private static final ImageIcon speed = new ImageIcon(addSpeed);

    private static final ImageIcon drawHov = new ImageIcon(drawCanvasHov);
    private static final ImageIcon clearHov = new ImageIcon(clearCanvasHov);
    
    private static final ImageIcon saveHov = new ImageIcon(saveScriptHov);
    private static final ImageIcon loadHov = new ImageIcon(loadScriptHov);
    private static final ImageIcon addHov = new ImageIcon(addScriptHov);    
    private static final ImageIcon clearScrHov = new ImageIcon(clearScriptHov);

    
    private static final ImageIcon pointHov = new ImageIcon(addPointHov);
    private static final ImageIcon speedHov = new ImageIcon(addSpeedHov);
    
    private static final ImageIcon drawPress = new ImageIcon(drawCanvasPress);
    private static final ImageIcon clearPress = new ImageIcon(clearCanvasPress);
    
    private static final ImageIcon savePress = new ImageIcon(saveScriptPress);
    private static final ImageIcon loadPress = new ImageIcon(loadScriptPress);
    private static final ImageIcon addPress = new ImageIcon(addScriptPress);
    private static final ImageIcon clearScrPress = new ImageIcon(clearScriptPress);
    
    private static final ImageIcon pointPress = new ImageIcon(addPointPress);
    private static final ImageIcon speedPress = new ImageIcon(addSpeedPress);
    
    private static final ImageIcon textImage = new ImageIcon(textBackground);

    public ImageLoader() {
        loadImage = new HashMap<String,ImageIcon>();
        
        loadImage.put("bground",bground);
        loadImage.put("canvas",canvas);
        loadImage.put("logoType",logoType);
        
        loadImage.put("draw",draw);
        loadImage.put("clear",clear);
        
        loadImage.put("save",save);
        loadImage.put("load",load);
        loadImage.put("add",add);
        loadImage.put("clearScr",clearScr);
        
        loadImage.put("point",point);
        loadImage.put("speed",speed);

        loadImage.put("drawHov",drawHov);
        loadImage.put("clearHov",clearHov);
        
        loadImage.put("saveHov",saveHov);
        loadImage.put("loadHov",loadHov);
        loadImage.put("addHov",addHov);
        loadImage.put("clearScrHov",clearScrHov);
        
        loadImage.put("pointHov",pointHov);
        loadImage.put("speedHov",speedHov);
        
        loadImage.put("drawPress",drawPress);
        loadImage.put("clearPress",clearPress);
        
        loadImage.put("savePress",savePress);
        loadImage.put("loadPress",loadPress);
        loadImage.put("addPress",addPress);
        loadImage.put("clearScrPress",clearScrPress);
        
        loadImage.put("pointPress",pointPress);
        loadImage.put("speedPress",speedPress);    
    
        loadImage.put("textimage",textImage); 
    }
    
    public ImageIcon load(String key) {
        return loadImage.get(key);
    }
    
    public ImageIcon[] buttons(String type) {
        ImageIcon[] buttonSet = new ImageIcon[3];
        buttonSet[0] = loadImage.get(type);
        buttonSet[1] = loadImage.get(type+"Hov");
        buttonSet[2] = loadImage.get(type+"Press");
        
        return buttonSet;
    }

}