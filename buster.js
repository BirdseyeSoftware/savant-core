var config = exports;

config['Browser Tests'] = {
    environment: 'browser',
    sources: [],
    tests: ["resources/js/savant_core_browser_test.js"]
};

 config['Server Tests'] = {
     environment: 'node',
     sources: [],
     tests: ["resources/js/savant_core_node_test.js"]
 };
