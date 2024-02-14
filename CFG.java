public class CFG {
    private Node startNode;
    private Container<Node> nodes;
    private Container<Edge> edges;
    private Container<Node> exitNodes;
    private Container<Path> Paths;



    public Container<Node> getNodes()
    {
        return nodes;
    }

    public Container<Edge> getEdges()
    {
        return edges;
    }

    public CFG(){
        startNode=null;
        nodes= new Container<Node>();
        edges= new Container<Edge>();
        exitNodes= new Container<Node>();
        Paths= new Container<>();
        //TODO: Implement the function
    }

    public CFG(Node[] nodes, Edge[] edges, Node sNode, Node[] exitNodes){
        startNode=sNode;
        if(nodes.length==0)
        {
            this.nodes= new Container<>();
        }
        else{
            this.nodes = new Container(nodes);
        }
        if(edges.length==0){
            this.edges= new Container<>();
        }
        else{
            this.edges= new Container<>(edges);
        }
         
        //nodes= new Container<Node>(nodes);
       /*edges= new Container<Edge>();*/
       if(exitNodes.length==0)
       {
        this.exitNodes= new Container<Node>();
       }
       else{
        this.exitNodes= new Container<Node>(exitNodes);
       }
        
        //TODO: Implement the function
    }

    public CFG(CFG other){
        startNode= new Node(other.startNode.getAnnotation());
        nodes=new Container<Node>();
        for(int c=0; c<other.nodes.GetSize(); c++)
        {
            Node[]temp=(Node[])(other.nodes.getEdge());
            nodes.Add(  new Node(  temp[c].getAnnotation()) );
        }
        edges=new Container<>();
        for(int c=0; c<other.edges.GetSize(); c++)
        {
            Edge[]temp=(Edge[])(other.edges.getEdge());
            edges.Add( new Edge(temp[c].getAnnotation(), temp[c].getNext(), temp[c].getCompTime()));
        }
        exitNodes=new Container<>();
        for(int c=0; c<other.exitNodes.GetSize(); c++)
        {
            Node[] temp=(Node[])other.exitNodes.toArray();
            exitNodes.Add( new Node(  temp[c].getAnnotation())  );
           // exitNodes.Add( new Node((other.exitNodes.getEdge()[c].getAnnotation() ) );
        }
        //TODO: Implement the function
    }

    public boolean isValid(){//fix
        //TODO: Implement the function
        if(startNode==null)
            return false;
        if(exitNodes.GetSize()<1)
            return false;
        boolean test=true;
        for(int c=0; c<nodes.GetSize(); c++)
        {
            if(isNotExistNode((Node)nodes.toArray()[c]))
            {
                if(!DoesItReachExist((Node)nodes.toArray()[c]))
                    return false;
            
            }
        }

       return test;
    }

    public boolean DoesItReachExist(Node n)
    {
        for(int c=0; c<exitNodes.GetSize(); c++)
        {
            if(isReachable(n,(Node) exitNodes.toArray()[c]))
                return true;
        }

        return false;
    }
    public boolean isNotExistNode(Node n)
    {
        for(int c=0; c<exitNodes.GetSize(); c++)
        {
            if(((Node)exitNodes.toArray()[c]).equals(n))
            {
                return false;
            }
        }

        return true;
    }

    public boolean isSESE(){
        //TODO: Implement the function
        if(isValid()&&exitNodes.GetSize()==1)
            return true;

        return false;
    }

    public int IndexNode(Node n)
    {
        for(int c=0; c<nodes.GetSize(); c++)
        {
            if(((Node)nodes.toArray()[c]).equals(n))
            {
                return c;
            }
        }
        return -1;
    }

    public int[][] labelCorrecting(Node start)
    {
        if(IndexNode(start)==-1)
            return new int[0][0];

        int[][] arr = new int[2][nodes.GetSize()];
        Container<Integer> toBeChecked= new Container<>();
        for(int c=0; c< nodes.GetSize(); c++)
        {
            arr[0][c]=Integer.MAX_VALUE;
            arr[1][c]=-1;

        }
        arr[0][IndexNode(start)]=0;
        toBeChecked.Add(IndexNode(start));
        int curr;
        int newDist;
        while(toBeChecked.GetSize() !=0)
        {
            curr=toBeChecked.RemoveVertex();
            Node nn=((Node)(nodes.toArray()[curr])); 
            for(int c=0; c<nn.getEdges().length; c++)
            {
                //int edgeD=((Node)(nodes.getEdge()[curr])).getEdges()[c]).getCompTime();
                newDist = arr[0][curr] + nn.getEdges()[c].getCompTime();
                
                if( IndexNode(  nn.getEdges()[c] .getNext()) !=-1 && newDist < arr[0][IndexNode(  nn.getEdges()[c] .getNext())])
                {
                    arr[0][IndexNode(nn.getEdges()[c] .getNext())]=newDist;
                    arr[1][IndexNode(nn.getEdges()[c] .getNext())]=curr;
                    if(toBeChecked.Search(IndexNode(nn.getEdges()[c] .getNext())) == null)
                    {
                        toBeChecked.Add(IndexNode(nn.getEdges()[c] .getNext()));
                    }
                }


            }
        }


        return arr;
    }
   
    public CFG[] splitGraph(){
        if(isSESE())
        {
            CFG[] arr= new CFG[1];
            arr[0]=this;
            return arr;
        }
        if(isValid())
        {
            CFG[] arr= new CFG[exitNodes.GetSize()];
            for(int c=0; c<exitNodes.GetSize(); c++)
            {
                arr[c]= new CFG();
                arr[c].startNode=startNode;
                arr[c].nodes.Add(startNode);
                arr[c].exitNodes.Add((Node)exitNodes.toArray()[c]);
                arr[c].nodes.Add((Node)exitNodes.toArray()[c]);
            }

            for(int c=0; c<nodes.GetSize(); c++)
            {
                for(int i=0; i<exitNodes.GetSize(); i++)
                {
                    if(isReachable(((Node)nodes.toArray()[c]), ((Node)exitNodes.toArray()[i])))
                    {
                        arr[i].nodes.Add((Node)nodes.toArray()[c]);
                    
                    }
                }
            }

           // Node 

            for(int i=0; i<exitNodes.GetSize(); i++)
            {
                Node [] nn=CreateNodeArr(arr[i].nodes, 4);

                Edge[] arr2=CreateEdgeArr(nn);

                arr[i].edges= new Container<>(arr2);
            }


            return arr;
        }
        return new CFG[0];
        //TODO: Implement the function
    }

    public Edge[]  FindEdges(Node start, Node end)
    {
        for(int c=0; c<start.getEdges().length; c++)
        {

        }
        return null;
    }

    public void AddE(Node start, Node end)
    {
        if(start == end)
        {

        }
    }

    public boolean isReachable(Node startNode, Node goalNode){

        if(startNode ==null || goalNode ==null)
            return false;
        
        int [][] arr=labelCorrecting(startNode);
        if(arr[0][IndexNode(goalNode)] != Integer.MAX_VALUE)
            return true;
        
        return false;
        //TODO: Implement the function

        
    }

    //public
    public int compTimeRequired(Path p){
        //TODO: Implement the function

        if(p==null)
            return -1;
        return p.computationalCostOfPath();

    }

    public Path shortestCompTimePath(Node sN, Node gN){
        if(sN.equals(gN))
        {
            Node[] arr= new Node[1];
            Edge[] e= new Edge[0];
            arr[0]=sN;
            Path p= new Path(sN, sN, arr, e);

            Path[] rt= new Path[1];
            rt[0]=p;
            return p;
        }
        //TODO: Implement the function
        int[][] arr=labelCorrecting(sN);
        /*for(int c=0; c<arr[0].length; c++)
        {
            System.out.print(arr[0][c] +" "+ arr[1][c]    + "      ");
        }*/
       // System.out.println();
        Container<Integer> list=Extract(IndexNode(gN), IndexNode(sN), arr);
        Node[] n=CreateNodeArr(list);
        Edge[] e= CreateEdgeArr(n);

        return new Path(sN, gN, n, e);


    }
    public Edge[] CreateEdgeArr(Node[]n)
    {
        Edge[] arr= new Edge[n.length-1];
        for(int c=0; c<n.length-1; c++)
        {
            arr[c]=n[c].CorrectEdge(n[c+1]);
        }

        return arr;
    }
    public Node[] CreateNodeArr(Container<Integer> list)
    {

       // list.print();
        Node[] arr= new Node[list.GetSize()];
        int i=0;
        for(int c=list.GetSize()-1; c>=0; c--)
        {
            arr[i++]=(Node)nodes.toArray()[((Integer)list.toArray()[c])];
        }
        return arr;
    }

    public Node[] CreateNodeArr(Container<Node> list, int v)
    {       
        Node[] arr= new Node[list.GetSize()];
        int i=0;
        for(int c=0; c<list.GetSize(); c++)
        {
            arr[c]=(Node)list.toArray()[c];
        }
        return arr;
    }

    public Container<Integer> Extract(int From, int Stop, int [][] arr)
    {
        Container<Integer> vertice= new Container<>();
        int pos=From;
        vertice.Add(From);
        do
        {   
            vertice.Add(arr[1][pos]);
            pos=arr[1][pos];

        }while(pos != Stop);

       // vertice.Add(Stop);
        return vertice;
    }
  
  
    public Path[] getPrimePaths(){

        Path[] simplePaths=getSimplePaths();
        Container<Path>PrimePath= new Container<>();
        for(int c=0; c<simplePaths.length; c++)
        {
            if(!isSubPath(simplePaths[c], simplePaths))
            {
                PrimePath.Add(simplePaths[c]);
            }
        }
        Path[] gt= new Path[PrimePath.GetSize()];
        
        for(int c=0; c<gt.length; c++)
        {
            gt[c]= new Path((Path)PrimePath.toArray()[c]);
        }
        return gt;
        //TODO: Implement the function
    }

    public boolean isSubPath(Path p, Path[] simplePaths)
    {

        for(int c=0; c<simplePaths.length; c++)
        {
            if(simplePaths[c].getNodes().GetSize()>p.getNodes().GetSize())
            {
                if(HaveSamePath(simplePaths[c], p))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean HaveSamePath(Path longer, Path shorter)
    {
        String l=longer.toString();
        String s=shorter.toString();

        if(l.contains(s))
            return true;

        return false;
    }

    public boolean HaveSameNode(Path longer, Path shorter)
    {

        for(int c=0; c<shorter.getNodes().GetSize(); c++)
        {
            if(!IsThere(longer, ((Node)shorter.getNodes().toArray()[c])))
            {
                return false;
            }
        }
        return true;
    }
    public boolean IsThere(Path p, Node n)
    {
        for(int c=0; c<p.getNodes().GetSize(); c++)
        {
            if(((Node)p.getNodes().toArray()[c]).equals(n))
            {
                return true;
            }
        }
        return false;
    }

    public Path[] getSimplePaths()
    {

        int len=nodes.GetSize()-1;

        return SimplePathOnLength(len);
        //TODO: Implement the function

    }

    public Path[] SimplePathOnLength(int len)
    {
        if(len>=nodes.GetSize())
            return new Path[0];

       // System.out.println("Hoold");
        Container<Path> SPaths= new Container<>();
        Node n;
        for(int c=0; c<nodes.GetSize(); c++)
        {
           // n= new Node(nodes.getEdge()[c].getAnnotation());
           // n.SetEdges(nodes.getEdge()[c].getEdges());
           n=(Node)nodes.toArray()[c];
           Node []nod=new Node[1];
            nod[0]=n;
            SPaths.Add(new Path( n,n,nod, new Edge[0] ));
        }
        //SPaths.print();
        //System.out.println("Hoold");
        //System.out.println(SPaths.GetSize());


        int length=1;
        int size;
        int Edgesize;
        Path Append;
        Path OldPath;
        Node SNode;
        Node ENode;
        Edge[] addEdge;
        Node[] addNodes;
        while(length<=len)
        {
            //SPaths.print();
            size=SPaths.GetSize();
            for(int c=0;c<size; c++)
            {
                if(((Path)(SPaths.toArray()[c])).getNodes().GetSize()==length)
                {
                    Edge[] ad = ((Path)SPaths.toArray()[c]).getEndNode().getEdges();
                    Edgesize=ad.length;
                    for(int i=0; i<Edgesize; i++)
                    {
                        SNode=(Node)((Path)(SPaths.toArray()[c])).getNodes().toArray()[length-1];
                        //System.out.println("Start --"+SNode);
                        ENode=(Node) ((Path)(SPaths.toArray()[c])).getEndNode().getEdges()[i].getNext();
                        //System.out.println("End--"+ENode);
                        addEdge= new Edge[1];
                        addEdge[0]=((Path)(SPaths.toArray()[c])).getEndNode().getEdges()[i];
                        addNodes= new Node[2];
                        addNodes[0]=SNode;
                        addNodes[1]=ENode;
                        Append= new Path(SNode, ENode, addNodes, addEdge);
                        //System.out.println(Append);
                        OldPath= new Path(((Path)(SPaths.toArray()[c])), false);
                        OldPath.appendToPath(Append);
                       // System.out.println(!OldPath.DuplicateNodes());
                        if(!OldPath.DuplicateNodes())
                            SPaths.Add(OldPath);

                    }

                }
            }
            length++;
        }

        Path[] gt= new Path[SPaths.GetSize()];
        
        for(int c=0; c<gt.length; c++)
        {
            gt[c]= new Path((Path)SPaths.toArray()[c]);
        }
        //System.out.println(" ");//dont forget;
        return gt;
        
       // return ((Path[])SPaths.toArray());
    }

    public void addNode(String annotation){

        Node n= new Node(annotation);
        addNode(n);
        //TODO: Implement the function
    }

    public void addNode(Node node){
        if(node==null)
            return;
    

        nodes.Add(node);

        //TODO: Implement the function
    }

    public void addEdge(String annotation, Node fromNode, Node toNode, int computationalTime){

        Edge n= new Edge(annotation, toNode, computationalTime);

        if(computationalTime<0)
            return;
        
        nodes.Add(toNode);
        nodes.Add(fromNode);
        fromNode.addEdge(toNode, annotation, computationalTime);
          
        edges.Add(n);
        

        //TODO: Implement the function
    }

    public Edge Find(String annotation)
    {
        String n;
        for(int c=0; c<edges.GetSize(); c++)
        {
            if(((Edge)(edges.getEdge()[c])).getAnnotation()==annotation)
                return ((Edge)(edges.getEdge()[c]));

        }

        return null;
    }

    public void addExitNode(Node n){
        if(n==null)
            return ;

        nodes.Add(n);
        exitNodes.Add(n);
        //TODO: Implement the function
    }

    public void addStartNode(Node n){
        if(n==null)
            return;

        if(startNode !=null){
            if(nodes.Search(n) == null)
            {
                nodes.Add(n);
            }
            return;
        }
        startNode=n;
        if(nodes.Search(n) == null)
        {
           // 
            nodes.Add(n);
            //System.out.println("Here");

        }

        //TODO: Implement the function
    }

    public String toString() {
        //Provided function, do not alter!!!
        String res = "";
        for(Object n: nodes.toArray()){
            res += n.toString();
        }
        return res;
    }

    public Node getNode(String annotation)
    {
        Node n= new Node(annotation);

        return (Node)nodes.Search(n);
        //TODO: Implement the function
    }
}
