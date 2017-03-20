module.exports = function(grunt) {

    // Project config
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),bower_concat: {
            all: {
                dest: 'build/app/assets/js/_bower.js',
                cssDest: 'build/app/assets/css/_bower.css',
                bowerOptions: {
                    relative: false
                }
            }
        },

        clean: [
            'build/**/*.*'
        ],
        concat:{
            js: {
                src: [
                    'app/public/static/app.js',
                    'app/public/**/*.js'
                ],
                dest: 'build/app/assets/js/built.js'
            },
            css: {
                src: [
                    'app/public/css/style.css',
                    'app/public/css/bootstrap.css'
                ],
                dest: 'build/app/assets/css/built.css'
            }
        },
        copy: {
            views: {
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['app/public/components/**/*.html'],
                        dest: 'build/app/views/'
                    },
                    {
                        expand: true,
                        flatten: true,
                        src: ['index.html'],
                        dest: 'build/app/views/'
                    },
                    {
                        expand: true,
                        flatten: true,
                        src: ['app/public/static/app.html'],
                        dest: 'build/app/views/'
                    }
                ]
            }
        },
        cssmin: {
            target: {
                files: [
                    {
                        expand: true,
                        cwd: 'build/app/assets/css',
                        src: ['*.css', '!*.min.css'],
                        dest: 'build/app/assets/css',
                        ext: '.min.css'
                    }
                ]
            }
        },
        jshint: {
            files: ['gruntfile.js'],
            options: {
                node: true,
                globals: {
                    'angular': true,
                    'console': false
                }
            }
        },
        watch:{
            scripts: {
                files:['*.js','app/**/**/*.*', 'app/**/*.*','!**/built.*'],
                tasks: ['clean', 'concat', 'bower_concat', 'copy'],
                options: {
                    interupt: true,
                    livereload: true
                }
            }
        }
    });

    // Load the plugin that provides the specified config tasks
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-bower-concat');

    //Concat js and css files
    grunt.registerTask('build', [
        'clean',
        'concat',
        'cssmin',
        'bower_concat',
        'copy:views',
        'watch'

    ]);

};