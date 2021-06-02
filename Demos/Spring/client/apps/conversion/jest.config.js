module.exports = {
  name: 'conversion',
  preset: '../../jest.config.js',
  coverageDirectory: '../../coverage/apps/conversion',
  snapshotSerializers: [
    'jest-preset-angular/AngularSnapshotSerializer.js',
    'jest-preset-angular/HTMLCommentSerializer.js'
  ]
};
