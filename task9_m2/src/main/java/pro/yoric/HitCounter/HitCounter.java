package pro.yoric.HitCounter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

public class HitCounter
    implements IDataController
{



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


    @Override
    public int getInfo()
    {
        return 0;
    }

    @Override
    public boolean setInfo()
    {
        return false;
    }


}
