import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;

public class S202MaximLyoen{
    public static void main(String[] args){
        Topology tp = new Topology();
        new JViewer(tp);
        tp.start();
  