import * as React from 'react';
import { StyleSheet, View, Text, Button } from 'react-native';
import Suprsend from '@suprsend/react-native-sdk';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Welcome to Suprsend SDK</Text>
      <Button
        title="Init"
        onPress={async () => {
          // Suprsend.setSuperProperties('age', 22);
          // Suprsend.identify('katta.sivaram@suprsend.com');
          // Suprsend.track('testing_event');
          Suprsend.reset();
          Suprsend.track('testing_event');
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
