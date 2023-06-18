package br.com.ada.utils;

import br.com.ada.model.ScheduleItem;

import java.util.List;

public class ShowUtilInfos {

    public static void showScheduleItens(List<? extends ScheduleItem> scheduleItems){
        for(ScheduleItem scheduleItem : scheduleItems){
            System.out.println(scheduleItem.getItemId());
            System.out.println(scheduleItem.getItemName());
        }
    }
}
