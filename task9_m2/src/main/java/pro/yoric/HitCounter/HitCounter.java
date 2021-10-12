package pro.yoric.HitCounter;

public class HitCounter
    implements IHitCounter
{
    public void init()
    {
        visitsCounter = 0;
    }

    @Override
    public void addVisit()
    {

    }


    //    public void doGet(HttpServletRequest req,
//                      HttpServletResponse response)
//        throws ServletException,
//            IOException
//    {
//        // Получаем ServletContext
//        ServletContext context = getServletContext();
//
//        // Получаем атрибут count из контекста и переводим его в Integer
//        Object countObj = context.getAttribute("count");
//        Integer count = (Integer) countObj;
//
//        // Если это первое посещение, присваиваем значение 1, если не первое, добавляем 1
//        if (count == null) {
//            count = 1;
//        } else {
//            count++;
//        }
//    }
    private int visitsCounter = 0;


}
