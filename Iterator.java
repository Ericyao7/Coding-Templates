Iterator entries = m.entrySet().iterator();

        while (entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            Integer value = (Integer) entry.getValue();

            if(value>1){
                res++;
            }

        }
