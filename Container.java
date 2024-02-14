public class Container<T>
{
   private T[] Arr;
   int size;

   public Container()
   {
        size=0;
        Arr= (T[]) new Object[0];
   }
   public Container(T[] Arr2)
   {
        Arr=Arr2;
        size=Arr2.length;
   }
   public void Add(Object[] arr, Boolean ch)
   {
        for(int c=0; c<arr.length; c++)
        {
            this.Add((T)arr[c]);
        }
   }

   public void print()
   {
        //System.out.println("Size " +GetSize());
        for(int c=0; c<GetSize(); c++)
        {
            //System.out.println("Size ");
            System.out.println(Arr[c]);
        }
   }
   public int GetSize()
   {
        return size;
   }
   public T RemoveVertex()
   {
        if(size==0)
            return null;

        T temp=Arr[0];
        Remove(temp);
        return temp;
   }

   @Override
   public boolean equals(Object o)
   {
        if(this==o) 
            return true;
        if(o==null) 
            return false;
        if(o.getClass() != this.getClass()) 
            return false;

        //if(Arr )
        if(Arr.length != ((Container<T>)o).Arr.length  )
            return false;
        
      //  System.out.println("Here");
        for(int c=0; c<Arr.length; c++)
        {
            if(! Arr[c].equals(((Container<T>)o).Arr[c])) 
                return false;
        }
        return true;
   }
   public void Add(T edg)
   {
        if(Search(edg) != null)
            return;  

        if(Arr.length==0)
        {
            size++;
            Arr = (T[])new Object[size];
            Arr[size-1]=edg;
            return;
        }
        else{
            size++;
            T[] temp = (T[]) new Object[size];
            temp[size-1]=edg;

            for(int c=0; c<Arr.length; c++)
            {
                temp[c]=Arr[c];
            }
            Arr=temp;
        }

   }

   public void Remove(T ed)
   {
        if(Arr==null)
        {
            return;
        }

        if(Search(ed)==null)
        {
            return ;
        }
        else{
            int c=0;
            for(; c<Arr.length; c++)
            {
                if(Arr[c].equals(ed))
                    break;

            }
            size--;
            T[] temp= (T[])new Object[size];
            int pos=0;
            for(int i=0; i<temp.length; i++)
            {
                if(i==c)
                {
                    pos++;
                    temp[i]=Arr[pos];
                    pos++;
                }
                else
                {
                    temp[i]=Arr[pos];
                    pos++;
                }
            }
            Arr=temp;
        }

   }

   public Object Search(T ed)
   {
        for(int c=0; c<Arr.length; c++)
        {
            if(((T)Arr[c]).equals(ed))
            {
                return Arr[c];
            }
        }
        return null;
   }

   /*public Object Search2(T ed)
   {
        for(int c=0; c<Arr.length; c++)
        {
            if(Arr[c].compareTo(ed)==0)
            {
                return Arr[c];
            }
        }
        return null;
   }*/

   

   public T[] getEdge()
   {
       
    
        return (T[])Arr;
   }

   public Object[] toArray()
   {
        return  Arr;
   }
}