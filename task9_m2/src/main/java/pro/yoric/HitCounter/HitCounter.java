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

    @Override
    public int getVisits()
    {
        return 0;
    }


//        ServletContext context = getServletContext();
//
//        // Получаем атрибут count из контекста и переводим его в Integer
//        Object countObj = context.getAttribute("count");
//        Integer count = (Integer) countObj;
//
//        if (count == null) {
//            count = 1;
//        } else {
//            count++;
//        }

    private int visitsCounter = 0;
}
