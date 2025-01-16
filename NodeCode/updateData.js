function processData(newData) {
  const timeGroups = new Map();
  const allTags = new Set();
  const previousValues = new Map();
  const timeFormats = new Map();
  const latestValues = new Map();

  // First pass: Group by time
  newData.forEach((item) => {
    const timeKey = new Date(item.time).getTime();
    if (!timeGroups.has(timeKey)) {
      timeGroups.set(timeKey, new Map());
      timeFormats.set(timeKey, item.time);
    }
    timeGroups.get(timeKey).set(item.tag, item);
    allTags.add(item.tag);
  });

  const result = [];
  const sortedTimes = Array.from(timeGroups.keys()).sort();

  sortedTimes.forEach((timeKey) => {
    const currentGroup = timeGroups.get(timeKey);
    const originalTimeFormat = timeFormats.get(timeKey);

    allTags.forEach((tag) => {
      if (currentGroup.has(tag)) {
        const currentValue = currentGroup.get(tag);
        result.push(currentValue);
        previousValues.set(tag, currentValue);
      } else {
        const prevValue = previousValues.get(tag);
        if (prevValue) {
          result.push({
            time: originalTimeFormat,
            tag: tag,
            tagvalue: prevValue.tagvalue,
          });
        }
      }
    });
  });

  // Update latestValues after all processing
  previousValues.forEach((value, tag) => {
    latestValues.set(tag, value);
  });

  return result;
}

// 테스트
const data = [
  { time: "2024-01-16T10:00:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:00:00", tag: "b", tagvalue: 2 },
  { time: "2024-01-16T10:00:00", tag: "c", tagvalue: 3 },
  { time: "2024-01-16T10:01:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:01:00", tag: "c", tagvalue: 5 },
  { time: "2024-01-16T10:02:00", tag: "c", tagvalue: 8 },
  { time: "2024-01-16T10:03:00", tag: "a", tagvalue: 9 },
  { time: "2024-01-16T10:03:00", tag: "c", tagvalue: 11 },
  { time: "2024-01-16T10:04:00", tag: "a", tagvalue: 12 },
];

const result = processData(data);
const resultdate = [
  { time: "2024-01-16T10:00:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:00:00", tag: "b", tagvalue: 2 },
  { time: "2024-01-16T10:00:00", tag: "c", tagvalue: 3 },
  { time: "2024-01-16T10:01:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:01:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:01:00", tag: "c", tagvalue: 5 },
  { time: "2024-01-16T10:02:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:02:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:02:00", tag: "c", tagvalue: 8 },
  { time: "2024-01-16T10:03:00", tag: "a", tagvalue: 9 },
  { time: "2024-01-16T10:03:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:03:00", tag: "c", tagvalue: 11 },
  { time: "2024-01-16T10:04:00", tag: "a", tagvalue: 12 },
  { time: "2024-01-16T10:04:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:04:00", tag: "c", tagvalue: 11 },
];
const testResult = JSON.stringify(result) === JSON.stringify(resultdate);
const moreData = [
  { time: "2024-01-16T10:05:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:05:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:06:00", tag: "c", tagvalue: 15 },
  { time: "2024-01-16T10:07:00", tag: "a", tagvalue: 16 },
  { time: "2024-01-16T10:07:00", tag: "b", tagvalue: 17 },
  { time: "2024-01-16T10:07:00", tag: "c", tagvalue: 18 },
];

const moreResult = processData(moreData);
const moreResultDate = [
  { time: "2024-01-16T10:05:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:05:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:05:00", tag: "c", tagvalue: 11 },
  { time: "2024-01-16T10:06:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:06:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:06:00", tag: "c", tagvalue: 15 },
  { time: "2024-01-16T10:07:00", tag: "a", tagvalue: 16 },
  { time: "2024-01-16T10:07:00", tag: "b", tagvalue: 17 },
  { time: "2024-01-16T10:07:00", tag: "c", tagvalue: 18 },
];

const testMoreResult =
  JSON.stringify(moreResult) === JSON.stringify(moreResultDate);

console.log(moreResult);

console.log(testResult);
