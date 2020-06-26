/*Initial Data*/
create(b:Goal{name:'What will I do with my life?', sequence: 1})
create(s:Goal{name:'I go to the School', sequence: 2})
create(g:Goal{name:'I go to the Gym', sequence: 2})
create(i:Goal{name:'I want to be an Instructor', sequence: 3})
create(f:Goal{name:'I want to be a Fighter', sequence: 3})
create(a:Goal{name:'I want to be an Academic', sequence: 3})
create(p:Goal{name:'I want to be a Professional', sequence: 3})
create(r:Goal{name:'I became Rich', sequence: 4})
create(o:Goal{name:'I became Poor', sequence: 4})

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
/*
Only comment when using to create a person for testing


CREATE(person:Person{name:'Paul'})
CREATE(person)<-[:ChosenBy]-(s)
CREATE(person)<-[:ChosenBy]-(p)
CREATE(person)<-[:ChosenBy]-(o)
*/