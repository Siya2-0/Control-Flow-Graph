public class Path {
    private final Node startNode;
    private Node endNode;
    private final Container<Node> nodes;
    private final Container<Edge> edges;

    public Path(Node startNode, Node endNode, Node[] nodes, Edge[] edges){
        this.startNode=startNode;
        this.endNode=endNode;
        
         this.nodes = new Container<>(nodes);
         this.edges= new Container<>(edges);
        

        //TODO: Implement the function
    }
    public Node getEndNode()
    {
        return endNode;
    }
    public Path(Path other){
        this.startNode=other.startNode;
        this.endNode=other.endNode;
        this.nodes= other.nodes;
        this.edges= other.edges;


        //TODO: Implement the function
    }
    public Path(Path other, boolean c){
        this.startNode= new Node(other.startNode.getAnnotation());
        this.startNode.SetEdges((Edge[])other.startNode.getEdges());
        this.endNode=new Node(other.endNode.getAnnotation());
        this.endNode.SetEdges((Edge[])other.endNode.getEdges());

        this.edges= new Container<>();
        this.edges.Add(other.edges.toArray(), false);
        this.nodes= new Container<>();
        this.nodes.Add(other.nodes.toArray(), false);

        
        //TODO: Implement the function
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null) return false;
        if(o.getClass() != this.getClass()) return false;

        if( !startNode.equals( ((Path)o).startNode) )
            return false;
        if( !endNode.equals( ((Path)o).endNode) )
            return false;
        
        if(! nodes.equals(((Path)(o)).nodes ))
            return false;

        if(! edges.equals(((Path)(o)).edges ))
            return false;

        return true;
    }

    public Container<Node> getNodes()
    {
        return nodes;
    }

    public Container<Edge> getEdges()
    {
        
        return edges;
    }
    public int compareTo(Path o)
    {
        if(startNode==o.startNode && endNode==o.endNode && nodes.getEdge()==o.nodes.getEdge() && edges.getEdge()==o.edges.getEdge())
            return 0;
        
        return -1;
    }
    public int computationalCostOfPath(){
        int TotalCost=0;
        for(int c=0; c<edges.GetSize(); c++)
        {
            TotalCost+=((Edge)edges.toArray()[c]).getCompTime();
        }
        return TotalCost;
        //TODO: Implement the function
    }

    @SuppressWarnings("unchecked")
    public void appendToPath(Path p){

        if(!endNode.equals(p.startNode))
                return  ;

        this.endNode=p.endNode;
        for(int c=0; c<p.nodes.GetSize(); c++)
        {
            this.nodes.Add(p.nodes.getEdge()[c]);
        }
        for(int c=0; c<p.edges.GetSize(); c++)
        {
            this.edges.Add(p.edges.getEdge()[c]);
        }
        //TODO: Implement the function
    }

    public boolean validPath(){
        //TODO: Implement the function

        for(int c=0; c<nodes.GetSize()-1; c++)
        {
            if(!Condition1(c, c))
            {
                return false;
            }
        }

        if(!Condition2())
        {
            return false;
        }

        return true;


    }
    //this function will check for duplicate Nodes in the path except when its start/end node
    public boolean DuplicateNodes()
    {
        for(int c=0; c<edges.GetSize(); c++)
        {
            Node n=((Edge)edges.toArray()[c]).getNext();
            if(isDuplicated(n, c))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isDuplicated(Node n, int e)
    {
        for(int c=0; c<edges.GetSize(); c++)
        {
            if(e !=c &&((Edge)edges.toArray()[c]).getNext().equals(n))
            {
                return true;
            }
        }
        return false;
    }

    public boolean Condition1(int n1, int e1)
    {
        if(n1+1 >= 0 && n1+1 < nodes.GetSize() && n1>=0 && n1<edges.GetSize() && edges.getEdge()[n1].getNext()==nodes.getEdge()[n1+1])
            return true;

        
        return false;

    }

    public boolean Condition2()
    {
        if(edges.GetSize()==0)
            return false;

        if(nodes.GetSize()==0)
            return false;

        if(edges.getEdge()[edges.GetSize()-1].getNext().equals(endNode) && nodes.getEdge()[nodes.GetSize()-1].equals(endNode) )
        {
            return true;
        }
        return false;
    }

    public String toString(){
        //Provided function, do not alter!!!
        String str = "";
        str += ((Node)nodes.toArray()[0]).getAnnotation();
        for(Object e: edges.toArray()){
            str += e.toString();
        }
        return str;
    }
    
}
