def cl = this.class.classLoader
ginfo=[]
while (cl){
    ginfo.add(cl)
    cl = cl.parent
}
dataMap.put("G_DECISION", ginfo)