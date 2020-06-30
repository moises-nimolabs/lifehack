//remove all nodes
match(n) detach delete n;

//create goal nodes
create(p:Goal{name:'What will I do with my life?', sequence: 1});
create(p:Goal{name:'I go to the School', sequence: 2});
create(p:Goal{name:'I go to the Gym', sequence: 2});
create(p:Goal{name:'I want to be an Instructor', sequence: 3});
create(p:Goal{name:'I want to be a Fighter', sequence: 3});
create(p:Goal{name:'I want to be an Academic', sequence: 3});
create(p:Goal{name:'I want to be a Professional', sequence: 3});
create(p:Goal{name:'I became Rich', sequence: 4});
create(p:Goal{name:'I became Poor', sequence: 4});

//create goal relationships
match(p:Goal{name:'What will I do with my life?'}) match(n:Goal{name:'I go to the School'}) create(p)-[:Path]->(n);
match(p:Goal{name:'What will I do with my life?'}) match(n:Goal{name:'I go to the Gym'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I go to the School'}) match(n:Goal{name:'I want to be an Academic'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I go to the School'}) match(n:Goal{name:'I want to be a Professional'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I go to the Gym'}) match(n:Goal{name:'I want to be an Instructor'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I go to the Gym'}) match(n:Goal{name:'I want to be a Fighter'}) create(p)-[:Path]->(n);


match(p:Goal{name:'I want to be an Academic'}) match(n:Goal{name:'I became Poor'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I want to be a Professional'}) match(n:Goal{name:'I became Rich'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I want to be an Instructor'}) match(n:Goal{name:'I became Poor'}) create(p)-[:Path]->(n);
match(p:Goal{name:'I want to be a Fighter'}) match(n:Goal{name:'I became Rich'}) create(p)-[:Path]->(n);