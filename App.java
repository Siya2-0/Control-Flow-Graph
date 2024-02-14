public class App {
    public static void main(String[] args) {
        //SpecExample1();

       

       

        test6();
    }
    public static void test9()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addExitNode(N5);
       /// cfg.addExitNode(N6);

       
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);
       // cfg.addEdge("E6", cfg.getNode("N3"), cfg.getNode("N6"), 0);


         //System.out.println(cfg.isSESE());
        CFG cfg2= new CFG(cfg);
        printGraph(cfg2);

        //printGraph(cfg);
    }
    public static void test8()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addExitNode(N5);
       /// cfg.addExitNode(N6);

       
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);
       // cfg.addEdge("E6", cfg.getNode("N3"), cfg.getNode("N6"), 0);


         //System.out.println(cfg.isSESE());
        CFG[] arr=cfg.splitGraph();
       // System.out.println(arr.length);
        for(CFG v: arr){
            System.out.println(v);
        //    System.out.println( );
        }

        //printGraph(cfg);
    }

    
    public static void test7()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addExitNode(N5);
        cfg.addExitNode(N6);

       
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);
        cfg.addEdge("E6", cfg.getNode("N3"), cfg.getNode("N6"), 0);


         //System.out.println(cfg.isSESE());
        CFG[] arr=cfg.splitGraph();
       // System.out.println(arr.length);
        for(CFG v: arr){
            System.out.println(v);
        //    System.out.println( );
        }

        //printGraph(cfg);
    }
    public static void test6()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
       //cfg.addNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addNode(N6);
        //cfg.addExitNode(N6);
        cfg.addExitNode(N5);

        
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);

        System.out.println(cfg.shortestCompTimePath(N1, N5));
        
       // printGraph(cfg);

    }

    public static void test5()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
       //cfg.addNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addNode(N6);
        //cfg.addExitNode(N6);
        cfg.addExitNode(N5);

        
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);

        System.out.println(cfg.shortestCompTimePath(N5, N5));
        
        printGraph(cfg);
    }

    public static void test4()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
       //cfg.addNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addNode(N6);
        //cfg.addExitNode(N6);
        cfg.addExitNode(N5);

        
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);

        CFG[] arr=cfg.splitGraph();
        //System.out.println(arr.length);
        for(CFG v: arr)
            System.out.println(v);
        
        printGraph(cfg);
        

    }

    public static void test3()
    {
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
       // Node N6 = new Node("N6");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
       //cfg.addNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        //cfg.addNode(N5);
        //cfg.addExitNode(N6);
        cfg.addExitNode(N5);

        
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);

       
        printGraph(cfg);
        System.out.println(cfg.isValid());
        
    }

    /*public static void printGraph(CFG graph){
        printBreaker();
        if(graph == null){
            System.out.println("NULL Graph");
        } else {
            System.out.println(graph.toString());
        }
        printBreaker();
    }*/

    /*public static void printBreaker(){
        System.out.println("###");
    }

    }*/
    public static void test2()
    {
        Integer[] Arr= new Integer[10];
        for(int c=0;c<Arr.length; c++)
            Arr[c]=c;

        Container<Integer> test= new Container<>(Arr);
      
        System.out.println("Non-Empty Test-----------------------------------------------");
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(new Integer("5"));
        test.RemoveVertex();
        System.out.println("Size  : "+ test.GetSize());

        Container<Integer> test2= new Container<>();
        System.out.println("Equal: " + test.equals(test2));
        Integer[] Arr2= new Integer[9];
        for(int c=0;c<Arr2.length; c++)
            Arr2[c]=c;
        Container<Integer> test3= new Container<>(Arr2);
        System.out.println("Equal: " + test.equals(test3));

        Integer[] Arr3= new Integer[10];
        for(int c=0;c<Arr3.length; c++)
            Arr3[c]=c+1;
        Container<Integer> test4= new Container<>(Arr3);
        System.out.println("Equal: " + test.equals(test4));

        Container<Integer> test5 = new Container<>(Arr);
        System.out.println("Equal: " + test.equals(test5));

        test.Add(1);
        test.Add(2);
        test.Add(3);
        test.Add(3);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(2);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(1);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(3);
        System.out.println("Size  : "+ test.GetSize());
        test.Add(1);
        test.Add(2);
        test.Add(3);
        test.Add(4);
        System.out.println("Size  : "+ test.GetSize());
        test.RemoveVertex();
        System.out.println("Size  : "+ test.GetSize());

        System.out.println("Search 4  : "+ test.Search(new Integer("4")));
        System.out.println("Search 12  : "+ test.Search( new Integer("12")));
        
    }

    public static void test1()
    {

        Container<Integer> test= new Container<>();
        System.out.println("Empty Test-----------------------------------------------");
        test.Remove(new Integer("5"));
        test.RemoveVertex();
        System.out.println("Size  : "+ test.GetSize());
        Container<Integer> test2= new Container<>();
        System.out.println("Equal: " + test.equals(test2));
        test.Add(1);
        test.Add(2);
        test.Add(3);
        test.Add(3);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(2);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(1);
        System.out.println("Size  : "+ test.GetSize());
        test.Remove(3);
        System.out.println("Size  : "+ test.GetSize());
        test.Add(1);
        test.Add(2);
        test.Add(3);
        test.Add(4);
        System.out.println("Size  : "+ test.GetSize());
        test.RemoveVertex();
        System.out.println("Size  : "+ test.GetSize());

        System.out.println("Search 4  : "+ test.Search(4));
        System.out.println("Search 5  : "+ test.Search(5));
    }

    public static void SpecExample1(){
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addExitNode(N5);

        /*extra
        Container<Node> Nodes=cfg.getNodes();

        Nodes.print();

        //code*/
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);

        /*extra
        Container<Edge> Edges=cfg.getEdges();

        Edges.print();

        //code*/
        printGraph(cfg);
        Path[] simplePaths = cfg.getSimplePaths();
        //System.out.println(simplePaths.length);
        for(Path p: simplePaths){
            System.out.println(p.toString());
        }
        printBreaker();
        Path[] primePaths = cfg.getPrimePaths();
        for(Path p: primePaths){
            System.out.println(p.toString());
        }
    }

    public static void printGraph(CFG graph){
        printBreaker();
        if(graph == null){
            System.out.println("NULL Graph");
        } else {
            System.out.println(graph.toString());
        }
        printBreaker();
    }

    public static void printBreaker(){
        System.out.println("###");
    }

/* Expected output
###
N1:
        -> E1 -[0]-> N2
N2:
        -> E2 -[0]-> N3
N3:
        -> E3 -[0]-> N4
        -> E5 -[0]-> N5
N4:
        -> E4 -[0]-> N3
N5:
        No out going edges

###
N1
N2
N3
N4
N5
N1-> E1 -[0]-> N2
N2-> E2 -[0]-> N3
N3-> E3 -[0]-> N4
N3-> E5 -[0]-> N5
N4-> E4 -[0]-> N3
N1-> E1 -[0]-> N2-> E2 -[0]-> N3
N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N2-> E2 -[0]-> N3-> E5 -[0]-> N5
N3-> E3 -[0]-> N4-> E4 -[0]-> N3
N4-> E4 -[0]-> N3-> E3 -[0]-> N4
N4-> E4 -[0]-> N3-> E5 -[0]-> N5
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E5 -[0]-> N5
###
N3-> E3 -[0]-> N4-> E4 -[0]-> N3
N4-> E4 -[0]-> N3-> E3 -[0]-> N4
N4-> E4 -[0]-> N3-> E5 -[0]-> N5
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E5 -[0]-> N5
 */

}
