/*Initial Data*/
create(b:Goal{name:'Begin', sequence: 1})
create(s:Goal{name:'School', sequence: 2})
create(g:Goal{name:'Gym', sequence: 2})
create(i:Goal{name:'Instructor', sequence: 3})
create(f:Goal{name:'Fighter', sequence: 3})
create(a:Goal{name:'Academic', sequence: 3})
create(p:Goal{name:'Professional, sequence: 3'})
create(r:Goal{name:'Rich', sequence: 4})
create(o:Goal{name:'Poor', sequence: 4})

CREATE (b)-[r1:Path]->(s)
CREATE (b)-[r2:Path]->(g)
CREATE (g)-[r3:Path]->(i)
CREATE (g)-[r4:Path]->(f)
CREATE (s)-[r5:Path]->(a)
CREATE (s)-[r6:Path]->(p)

CREATE (i)-[r7:Path]->(o)
CREATE (f)-[r8:Path]->(r)


CREATE (a)-[r9:Path]->(o)
CREATE (p)-[r10:Path]->(r)