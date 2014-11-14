package reger.mega;

import reger.core.Debug;


public class ChartFieldFactory {
    /**
     * Accepts a fieldtype and returns a FieldType handler object.
     * @param fieldtype
     * @return
     */
    public static ChartField getHandlerByFieldtype(int fieldtype){

        if (fieldtype==FieldType.FIELDTYPEDROPDOWN){
            return new FieldTypeDropdown();
        } else if (fieldtype==FieldType.FIELDTYPEHORIZONTALRADIOS){
            return new FieldTypeHorizontalradios();
        } else if (fieldtype==FieldType.FIELDTYPENUMERICRANGE){
            return new FieldTypeNumericrange();
        } else if (fieldtype==FieldType.FIELDTYPETEXTBOX){
            return new FieldTypeTextbox();
        } else if (fieldtype==FieldType.FIELDTYPETIME){
            return new FieldTypeTimeperiod();
        } else if (fieldtype==FieldType.FIELDTYPEVERTICALRADIOS){
            return new FieldTypeVerticalradios();
        } else if (fieldtype==FieldType.XAXISENTRYORDER){
            return new ChartFieldEntryorder();
        } else if (fieldtype==FieldType.XAXISTIMEOFDAY) {
            return new ChartFieldEntryHourofday();
        } else if (fieldtype==FieldType.XAXISDAYOFWEEK) {
            return new ChartFieldEntryDayofweek();
        } else if (fieldtype==FieldType.XAXISDAYOFMONTH) {
            return new ChartFieldEntryDayofmonth();
        } else if (fieldtype==FieldType.XAXISCALENDARDAYS) {
            return new ChartFieldEntryDaysAgo();
        } else if (fieldtype==FieldType.XAXISCALENDARWEEKS) {
            return new ChartFieldEntryWeeksAgo();
        } else if (fieldtype==FieldType.XAXISCALENDARMONTHS) {
            return new ChartFieldEntryMonthsAgo();
        } else if (fieldtype==FieldType.XAXISDATETIME) {
            return new ChartFieldEntrydatetime();
        } else if (fieldtype==FieldType.YAXISCOUNT) {
            return new ChartFieldEntrycount();
        } else {
            Debug.debug(3, "No handler found: ChartFieldFactory.getHandlerByFieldtype - incoming fieldtype=" + fieldtype, "");
            return null;
        }
    }
}


