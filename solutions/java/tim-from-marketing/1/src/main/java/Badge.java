class Badge {
    
    public String print(Integer id, String name, String department) {
        StringBuilder sb = new StringBuilder();

        if (id != null) {
            sb.append(new String().format("[%d] - ", id));
        }

        sb.append(new String().format("%s - ", Badge.coalesce(name, "NULL")));
        sb.append(new String().format("%S", Badge.coalesce(department, "OWNER")));

        return sb.toString();
    }

    private static String coalesce(Object item, String defaultValue) {
        return item == null ? defaultValue : item.toString();
    }

}
