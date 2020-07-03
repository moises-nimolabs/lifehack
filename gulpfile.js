const gulp = require('gulp')
const shell = require('gulp-shell')


gulp.task('build', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose run --rm maven mvn clean install',
        'docker-compose run --rm netcore dotnet publish',
        'docker-compose run --rm node bash -c "yarn install --no-bin-links && npm run-script dist"'
    ]));
});

gulp.task('start-db', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose up -d db'
    ]));
});

gulp.task('logs-db', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose logs db'
    ]));
});

gulp.task('run-db-initial-data', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose exec -d db bash -c "cat /var/lib/neo4j/import/app.data.cypher | bin/cypher-shell -u neo4j -p @abc123 --debug"',
        'echo Check http://192.168.99.100:7474 to see if the data is loaded correctly'
    ]))
});

gulp.task('start-apps', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose up -d data-api api web',
        'echo data-api: http://192.168.99.100:8080/goal',
        'echo api: http://192.168.99.100:8000/api/goal',
        'echo web: http://192.168.99.100:4200'
    ]));
});

gulp.task('logs-data-api', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose logs data-api'
    ]));
});

gulp.task('logs-api', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose logs api'
    ]));
});

gulp.task('logs-web', () => {
    return gulp.src('*.js', {read: false})
    .pipe(shell([
        'docker-compose logs web'
    ]));
});

gulp.task('shutdown', () => {
    return gulp.src('*.js')
    .pipe(shell([
        'docker-compose down'
    ]));
})