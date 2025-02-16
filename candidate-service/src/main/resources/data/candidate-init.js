//create db
db=db.getSiblingDB('candidate');

//create user
db.createUser({
    user: 'candidate_user',
    pwd: 'candidate_password',
    roles: [
    {
        role: 'readWrite',
        db: 'candidate'
    }]
});

// create collection
db.createCollection('candidate');


//create docs
db.candidate.insertMany([
    {
        _id: '1001',
        name: 'ABC',
        skills: ['java', 'spring', 'docker']
    },
    {
        _id: '1002',
        name: 'BCD',
        skills: ['java']
    },
    {
        _id: '1003'',
        name: 'CDF',
        skills: ['agile', 'jira']
    },
    {
        _id: '1004',
        name: 'DFG',
        skills: ['java', 'jira', 'project']
    }
]);