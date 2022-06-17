package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    int widht, height;
    String title;
    private long glfwWindow;

    private static Window window = null;

    private Window(){
        this.widht=1920;
        this.height=1080;
        this.title="Super Mario";
    }

    public static Window get(){
        if (Window.window==null){
            Window.window=new Window();
        }
        return Window.window;
    }

    public void run(){
        System.out.println("Hello LWJGL"+ Version.getVersion()+"!");

        init();
        loop();
    }

    public void init(){
        // Setup an error callback
        GLFWErrorCallback.createPrint(System.err).set();

        //Initialize GLFW
        if(!GLFW.glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        //Configure GLFW
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW_MAXIMIZED,GLFW_TRUE);

        //Create the window
        glfwWindow = glfwCreateWindow(this.widht, this.height, this.title, NULL, NULL);
        if(glfwWindow==NULL){
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        //Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        //Enable Vsync
        glfwSwapInterval(1);

        //Make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }

    public void loop(){
    }
}
