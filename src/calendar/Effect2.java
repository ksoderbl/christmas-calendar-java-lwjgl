package calendar;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

// Using this we don't have to write GL11. everywhere.
// import static org.lwjgl.opengl.GL11.*;

public class Effect2 implements Effect
{
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    public static final String TITLE = "Calendar Effect 2";
    public static final int FPS_CAP = 60;
    
    private int cubeList;
    private float rot[] = {0.0f, 0.0f, 0.0f};
    /* initial rotation speeds of cubes */
    private float w[] = {0.1f, 0.2f, 0.3f};
    private float MY_Z0 = 22.0f;
    private float my_z = MY_Z0;


    private float globalAmbient[]  = { 0.1f, 0.1f, 0.1f, 1.0f };

    private float light0Ambient[]  = { 0.1f, 0.1f, 0.1f, 1.0f };
    private float light0Diffuse[]  = { 1.0f, 1.0f, 1.0f, 1.0f };
    private float light0Specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private float light0Position[] = { 20.0f, 20.0f, 20.0f, 1.0f };

    private float matAmbient[]     = { 0.2f, 0.2f, 0.2f, 1.0f };
    /*private float matDiffuse[]     = { 0.8f, 0.8f, 0.8f, 1.0f };*/
    private float matSpecular[]    = { 1.0f, 1.0f, 1.0f, 1.0f };
    private float matEmission[]    = { 0.0f, 0.0f, 0.0f, 1.0f };
    private float matShininess[]   = { 10.0f, 0.0f, 0.0f, 0.0f };
    
    public FloatBuffer makeFloatBuffer(float[] array) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(array.length);
        buffer.put(array);
        buffer.flip();
        return buffer;
    }
    
    public void init() {
        float matSpecular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
        float matShininess[] = { 50.0f, 0.0f, 0.0f, 0.0f };
        float lightPosition[] = { 1.0f, 1.0f, 1.0f, 0.0f };
        float whiteLight[] = { 1.0f, 1.0f, 1.0f, 1.0f };
        
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, makeFloatBuffer(matSpecular));
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SHININESS, makeFloatBuffer(matShininess));
        
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, makeFloatBuffer(lightPosition));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, makeFloatBuffer(whiteLight));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, makeFloatBuffer(whiteLight));

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_LIGHT0);
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        // useful?
        GL11.glEnable(GL11.GL_NORMALIZE);
    }

    
//    radius
//    The radius of the sphere. 
//    slices
//    The number of subdivisions around the Z axis (similar to lines of longitude). 
//    stacks
//    The number of subdivisions along the Z axis (similar to lines of latitude). 
    public void solidSphere(double radius, int slices, int stacks) {
        float w2 = 1.0f;
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(w2, w2, w2);
        GL11.glVertex3f(w2, -w2, w2);
        GL11.glVertex3f(-w2, -w2, w2);
        GL11.glVertex3f(-w2, w2, w2);
        GL11.glEnd();
        
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(w2, w2, -w2);
        GL11.glVertex3f(w2, -w2, -w2);
        GL11.glVertex3f(-w2, -w2, -w2);
        GL11.glVertex3f(-w2, w2, -w2);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3f(w2, w2, w2);
        GL11.glVertex3f(w2, w2, -w2);
        GL11.glVertex3f(w2, -w2, w2);
        GL11.glVertex3f(w2, -w2, -w2);
        GL11.glVertex3f(-w2, -w2, w2);
        GL11.glVertex3f(-w2, -w2, -w2);
        GL11.glVertex3f(-w2, w2, w2);
        GL11.glVertex3f(-w2, w2, -w2);
        GL11.glEnd();
        
        double twopi = 2 * Math.PI;
        
        // Normals are not correct
        
//        // torus
//        for (int i = 0; i < stacks; i++) {
//            GL11.glBegin(GL11.GL_QUAD_STRIP);
//            for (int j = 0; j <= slices; j++) {
//                for (int k = 1; k >= 0; k--) {
//                    double s = (i + k) % stacks + 0.5;
//                    double t = (double) (j % slices);
//                    double x = (1 + .3 * Math.cos(s * twopi / stacks)) * Math.cos(t * twopi / slices);
//                    double y = (1 + .3 * Math.cos(s * twopi / stacks)) * Math.sin(t * twopi / slices);
//                    double z = .3 * Math.sin(s * twopi / stacks);
//
//                    GL11.glNormal3d(x, y, z);
//                    GL11.glVertex3d(x, y, z);
//                }
//            }
//            GL11.glEnd();
//        }

//        // hourglass
//        for (int i = 0; i < stacks; i++) {
//            GL11.glBegin(GL11.GL_QUAD_STRIP);
//            for (int j = 0; j <= slices; j++) {
//                for (int k = 1; k >= 0; k--) {
//                    double s = (i + k) % stacks + 0.5;
//                    double t = (double) (j % slices);
//                    double x = radius * Math.cos(t * twopi / slices) * Math.sin(s * twopi / stacks);
//                    double y = radius * Math.sin(t * twopi / slices) * Math.sin(s * twopi / stacks);
//                    double z = radius * Math.sin(s * twopi / stacks);
//                    
//                    GL11.glNormal3d(x, y, z);
//                    GL11.glVertex3d(x, y, z);
//                }
//            }
//            GL11.glEnd();
//        }
//

        // sphere
        for (int i = 0; i < stacks; i++) {
            GL11.glBegin(GL11.GL_QUAD_STRIP);
            for (int j = 0; j <= slices; j++) {
                for (int k = 1; k >= 0; k--) {
                    double s = (i + k) % stacks + 0.5;
                    double t = (double) (j % slices);
                    double x = radius * Math.cos(t * twopi / slices) * Math.sin(s * twopi / stacks);
                    double y = radius * Math.sin(t * twopi / slices) * Math.sin(s * twopi / stacks);
                    double z = radius * Math.cos(s * twopi / stacks);
                    
                    // Length of vector (x, y, z) equals radius, thefore divide each of x, y and z in the glNormal3d
                    // by radius.
                    
                    GL11.glNormal3d(x / radius, y / radius, z / radius);
                    GL11.glVertex3d(x, y, z);
                    
                }
            }
            GL11.glEnd();
        }
    }
    
    public void drawCube()
    {
        if (false) {
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex3f(0.0f, 0.0f, 0.5f);
            GL11.glVertex3f(0.0f, 0.0f, 1.5f);
            GL11.glEnd();
            GL11.glEnable(GL11.GL_LIGHTING);    
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        GL11.glVertex3f( 0.5f,  0.5f,  0.5f); /* front face */
        GL11.glVertex3f(-0.5f,  0.5f,  0.5f);
        GL11.glVertex3f(-0.5f, -0.5f,  0.5f);
        GL11.glVertex3f( 0.5f, -0.5f,  0.5f);

        GL11.glNormal3f(1.0f, 0.0f, 0.0f);
        GL11.glVertex3f( 0.5f,  0.5f, -0.5f); /* right face */
        GL11.glVertex3f( 0.5f,  0.5f,  0.5f);
        GL11.glVertex3f( 0.5f, -0.5f,  0.5f);
        GL11.glVertex3f( 0.5f, -0.5f, -0.5f);

        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        GL11.glVertex3f(-0.5f,  0.5f, -0.5f); /* back face */
        GL11.glVertex3f( 0.5f,  0.5f, -0.5f);
        GL11.glVertex3f( 0.5f, -0.5f, -0.5f);
        GL11.glVertex3f(-0.5f, -0.5f, -0.5f);


        GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
        GL11.glVertex3f(-0.5f,  0.5f,  0.5f); /* left face */
        GL11.glVertex3f(-0.5f,  0.5f, -0.5f);
        GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
        GL11.glVertex3f(-0.5f, -0.5f,  0.5f);

        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glVertex3f( 0.5f,  0.5f, -0.5f); /* top face */
        GL11.glVertex3f(-0.5f,  0.5f, -0.5f);
        GL11.glVertex3f(-0.5f,  0.5f,  0.5f);
        GL11.glVertex3f( 0.5f,  0.5f,  0.5f);

        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        GL11.glVertex3f( 0.5f, -0.5f,  0.5f); /* bottom face */
        GL11.glVertex3f(-0.5f, -0.5f,  0.5f);
        GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
        GL11.glVertex3f( 0.5f, -0.5f, -0.5f);
        GL11.glEnd();
    }

    void drawCubes(int nx, int ny, int nz) {
        int i, j, k;
        float x, y, z;
        float r, g, b;
        float d;

        /* distance between two adjacent cubes' centers */
        d = 1.5f; 
        
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
                    
        for (i = 0; i < nx; i++) {
            for (j = 0; j < ny; j++) {
                for (k = 0; k < nz; k++) {
                    GL11.glPushMatrix();
                    r = ((float)(nx - i)) / nx;
                    g = ((float)(ny - j)) / ny;
                    b = ((float)(nz - k)) / nz;
                    
                    x = ((0.5f * nx - i) - 0.5f) * d;
                    y = ((0.5f * ny - j) - 0.5f) * d;
                    z = ((0.5f * nz - k) - 0.5f) * d;
                    
                    GL11.glTranslatef(x, y, z);
                    GL11.glColor3f(r, g, b);
                    drawCube();
                    
                    GL11.glPopMatrix();
                }
            }
        }

    }
    
    public void display() {
        int i;
        //char s[256];

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glShadeModel(GL11.GL_SMOOTH);

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, makeFloatBuffer(light0Position));
        
        GLU.gluLookAt(
            0.0f, 0.0f, my_z,        /* eye */
            0.0f, 0.0f, my_z - 1.0f,  /* ctr */
            0.0f, 1.0f, 0.0f);        /* up */
        GL11.glRotatef(rot[0], 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(rot[1], 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(rot[2], 0.0f, 0.0f, 1.0f);
        for (i = 0; i < 3; i++) {
            rot[i] += w[i];
            if (rot[i] >= 360.0f)
                rot[i] -= 360.0f;
            if (rot[i] < 0.0f)
                rot[i] += 360.0f;
        }


        drawCubes(16, 16, 16);

        //glCallList(cube_list);

        GL11.glDisable(GL11.GL_LIGHTING);

//        stars_draw();
//
//        if (messages_on()) {
//            sprintf(s, "w0: %.1f w1: %.1f w2: %.1f", w[0], w[1], w[2]);
//            messages_print(s, frame_count, fontcolor);
//        }
//
//        frame_count++;
    }
    
    public void mouse() {
        if (Mouse.isButtonDown(0)) {
            System.out.println("Mouse button 0 is down");
        }
    }
    
    public void keyboard() {
        if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
            GL11.glRotatef( 2f, 1.0f, 0.0f, 0.0f);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            GL11.glRotatef(-2f, 1.0f, 0.0f, 0.0f);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            GL11.glRotatef( 2f, 1.0f, 0.0f, 0.0f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_Y)) {
            GL11.glRotatef(2f, 0.0f, 1.0f, 0.0f);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            GL11.glRotatef(-2f, 0.0f, 1.0f, 0.0f);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            GL11.glRotatef(2f, 0.0f, 1.0f, 0.0f);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
            GL11.glLoadIdentity();
            GLU.gluLookAt(0f, 0f, 10f, 0f, 0f, 0f, 0f, 1f, 0f);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            Display.destroy();
            System.exit(0);
        }
    }
    
    public void reshape(int w, int h) {
        float fw = (float)w;
        float fh = (float)h;

        GL11.glViewport(0,0, w, h);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(50.0f, fw / fh, 0.1f, 1000.0f);
    }
    
    public void start() {
        Window window = new Window(WIDTH, HEIGHT, TITLE);
        reshape(WIDTH, HEIGHT);
        init();

        while (!Display.isCloseRequested()) {
            Display.sync(FPS_CAP);

            mouse();
            keyboard();
            
            display();
            
            
//            if (!Mouse.isButtonDown(0)) {
//            }
            
            if (Display.wasResized()) {
                reshape(Display.getWidth(), Display.getHeight());
            }
            
            Display.update();
        }
        
        Display.destroy();
    }
    
    public static void main(String[] args) {
        Effect2 effect = new Effect2();
        effect.start();
    }
}
